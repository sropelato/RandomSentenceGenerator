# Random Sentence Generator

Generate random expressions based on a pattern using Part-of-speech (POS) tags.
The Random Sentence Generator parses the pattern and replaces each tag by a random token from the Brown corpus, annotated with the given POS tag.

### Usage

Specify a pattern consisting of normal text and POS tags in angle brackets. The optional iterations parameter defines the number of senteces to be generated with the given pattern. See the example below.

### Example

    java -jar RandomSentenceGenerator.jar --pattern "The <JJ> <NNS> <BED> <JJ>." --iterations 3

The above command may return something like this:

    The new costs were inherent.
    The proud waves were heavy.
    The collective shorts were interesting.

### POS tags

| Tag | Definition |
| --- | --- |
| . | sentence (. ; ? *) |
| ( | left paren |
| ) | right paren |
| * | not, n't |
| -- | dash |
| , | comma |
| : | colon |
| ABL | pre-qualifier (quite, rather) |
| ABN | pre-quantifier (half, all) |
| ABX | pre-quantifier (both) |
| AP | post-determiner (many, several, next) |
| AT | article (a, the, no) |
| BE | be |
| BED | were |
| BEDZ | was |
| BEG | being |
| BEM | am |
| BEN | been |
| BER | are, art |
| BEZ | is |
| CC | coordinating conjunction (and, or) |
| CD | cardinal numeral (one, two, 2, etc.) |
| CS | subordinating conjunction (if, although) |
| DO | do |
| DOD | did |
| DOZ | does |
| DT | singular determiner/quantifier (this, that) |
| DTI | singular or plural determiner/quantifier (some, any) |
| DTS | plural determiner (these, those) |
| DTX | determiner/double conjunction (either) |
| EX | existential there |
| FW | foreign word (hyphenated before regular tag) |
| HV | have |
| HVD | had (past tense) |
| HVG | having |
| HVN | had (past participle) |
| IN | preposition |
| JJ | adjective |
| JJR | comparative adjective |
| JJS | semantically superlative adjective (chief, top) |
| JJT | morphologically superlative adjective (biggest) |
| MD | modal auxiliary (can, should, will) |
| NC | cited word (hyphenated after regular tag) |
| NN | singular or mass noun |
| NN$ | possessive singular noun |
| NNS | plural noun |
| NNS$ | possessive plural noun |
| NP | proper noun or part of name phrase |
| NP$ | possessive proper noun |
| NPS | plural proper noun |
| NPS$ | possessive plural proper noun |
| NR | adverbial noun (home, today, west) |
| OD | ordinal numeral (first, 2nd) |
| PN | nominal pronoun (everybody, nothing) |
| PN$ | possessive nominal pronoun |
| PP$ | possessive personal pronoun (my, our) |
| PP$$ | second (nominal) possessive pronoun (mine, ours) |
| PPL | singular reflexive/intensive personal pronoun (myself) |
| PPLS | plural reflexive/intensive personal pronoun (ourselves) |
| PPO | objective personal pronoun (me, him, it, them) |
| PPS | 3rd. singular nominative pronoun (he, she, it, one) |
| PPSS | other nominative personal pronoun (I, we, they, you) |
| PRP | Personal pronoun |
| PRP$ | Possessive pronoun |
| QL | qualifier (very, fairly) |
| QLP | post-qualifier (enough, indeed) |
| RB | adverb |
| RBR | comparative adverb |
| RBT | superlative adverb |
| RN | nominal adverb (here, then, indoors) |
| RP | adverb/particle (about, off, up) |
| TO | infinitive marker to |
| UH | interjection, exclamation |
| VB | verb, base form |
| VBD | verb, past tense |
| VBG | verb, present participle/gerund |
| VBN | verb, past participle |
| VBP | verb, non 3rd person, singular, present |
| VBZ | verb, 3rd. singular present |
| WDT | wh- determiner (what, which) |
| WP$ | possessive wh- pronoun (whose) |
| WPO | objective wh- pronoun (whom, which, that) |
| WPS | nominative wh- pronoun (who, which, that) |
| WQL | wh- qualifier (how) |
| WRB | wh- adverb (how, where, when) |

*Source: [https://en.wikipedia.org/wiki/Brown_Corpus](https://en.wikipedia.org/wiki/Brown_Corpus)*



