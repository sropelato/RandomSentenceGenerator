package net.ropelato.rsgen;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RandomSentenceGenerator
{
	public static final String TOKEN_TYPE_SEPARATOR = "/";

	private final Map<String, List<String>> typeTokenMap = new HashMap<>();
	private final Random random;

	public RandomSentenceGenerator()
	{
		random = new Random(System.currentTimeMillis());

		// read corpus files
		//for(int i = 0; i < 1; i++)
		for(int i = 0; i < 26; i++)
		{
			//for(int j = 1; j < 2; j++)
			for(int j = 0; j < 100; j++)
			{
				String filename = "brown/c" + ((char)(i + 97)) + (j < 10 ? "0" + j : j);
				if(new File(filename).exists())
				{
					try
					{
						BufferedInputStream in = new BufferedInputStream(new FileInputStream(filename));
						String content = new String(in.readAllBytes());
						String[] tokens = content.split("[\n ]");
						for(String token : tokens)
						{
							token = token.replaceAll("[\t\n ]*", "");

							String tokenText;
							String tokenType;
							if(!token.contains("/"))
								continue;
							else if(token.split(TOKEN_TYPE_SEPARATOR).length == 2)
							{
								tokenText = token.split(TOKEN_TYPE_SEPARATOR)[0];
								tokenType = token.split(TOKEN_TYPE_SEPARATOR)[1];
							}
							else
							{
								tokenText = token.split(TOKEN_TYPE_SEPARATOR)[0];
								for(int t = 1; t < token.split(TOKEN_TYPE_SEPARATOR).length - 1; t++)
									tokenText += TOKEN_TYPE_SEPARATOR + token.split(TOKEN_TYPE_SEPARATOR)[t];
								tokenType = token.split(TOKEN_TYPE_SEPARATOR)[token.split(TOKEN_TYPE_SEPARATOR).length - 1];
							}

							if(!typeTokenMap.containsKey(tokenType))
								typeTokenMap.put(tokenType, new ArrayList<>());
							typeTokenMap.get(tokenType).add(tokenText);
						}
					}
					catch(Exception e)
					{
						throw new RuntimeException(e);
					}
				}
			}
		}
	}

	public String getRandomSentence(String pattern)
	{
		String result = pattern;

		// replace counted tokens
		Pattern regexPattern = Pattern.compile("<([A-Za-z]+[-]?[a-z.,`'\\$]*)>");

		boolean noTokens = false;
		while(!noTokens)
		{
			Matcher matcher = regexPattern.matcher(result);
			if(matcher.find())
			{
				String tokenType = matcher.group(1);
				if(!typeTokenMap.containsKey(tokenType) || typeTokenMap.get(tokenType).size() == 0)
					throw new RuntimeException("No tokens with type " + tokenType);
				String replacement = typeTokenMap.get(tokenType).get((int)Math.floor(random.nextDouble() * (typeTokenMap.get(tokenType).size())));
				result = result.replace("<" + tokenType + ">", replacement);

			}
			else
				noTokens = true;
		}

		return result;
	}
}
