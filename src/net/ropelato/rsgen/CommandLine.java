package net.ropelato.rsgen;

import java.util.Arrays;
import java.util.List;

public class CommandLine
{
	public static void main(String[] args)
	{
		List<String> arguments = Arrays.asList(args);

		// read pattern
		String pattern = null;
		if(arguments.contains("--pattern") && arguments.indexOf("--pattern") < arguments.size() - 1)
			pattern = arguments.get(arguments.indexOf("--pattern") + 1);
		if(pattern == null)
		{
			System.err.println("No pattern has been specified");
			System.exit(1);
		}

		// read iterations
		int iterations = 1;
		if(arguments.contains("--iterations") && arguments.indexOf("--iterations") < arguments.size() - 1)
		{
			if(arguments.get(arguments.indexOf("--iterations") + 1).matches("^[1-9]+[0-9]*$"))
				iterations = Integer.parseInt(arguments.get(arguments.indexOf("--iterations") + 1));
			else
			{
				System.err.println("Invalid argument for --iterations");
				System.exit(1);
			}
		}

		// create random sentence generator and print generated sentences
		RandomSentenceGenerator rsgen = new RandomSentenceGenerator();
		for(int i = 0; i < iterations; i++)
		{
			System.out.println(rsgen.getRandomSentence(pattern));
		}
	}
}
