# SLR Documentation

## Python project
For checking the agreement between the different researchers.

## Literature Search Query Generation Tool

This tool helps you to create search queries for some of the common scientific literature databases.
Especially if there are a lot of keywords involved or when the list of keywords is still volatile,  this tool can help you generate the respective search strings automatically.

### Usage

There are generators for the databases of IEEE Xplore, ACM Digital Library, Scopus, Web of Science and SpringerLink.
Currently only the Metadata Title, Abstract and Keywords are supported (but of course can be easily extended).
The keywords loaded for the query generation can be found in the `resources` directory.

Example usecases are provided in the `searchtool` directory.

See the following excerpt of the `ACMSearch.java`:
```
logger.info("---------- Fourth Query ----------");
String keywordFilePath = "src" + FILE_PATH_SEP + "main" + FILE_PATH_SEP + "resources" + FILE_PATH_SEP + "keywords" + FILE_PATH_SEP + "keywords_v2.txt";
List<String> keywordList = Util.readKeywords(keywordFilePath);

BaseQuery keywordQuery = new BaseQuery();
keywordQuery.setKeywordList(keywordList);
keywordQuery.setBooleanOperatorType(BooleanOperatorType.OR);

BaseQuery softwareQuery = new BaseQuery();
softwareQuery.addKeyword("software");
softwareQuery.addKeyword("system");
softwareQuery.setBooleanOperatorType(BooleanOperatorType.OR);

BaseQuery securityQuery = new BaseQuery();
securityQuery.addKeyword("security");
securityQuery.setBooleanOperatorType(BooleanOperatorType.OR);


SearchTool searchtool = new SearchTool();
searchtool.addMetaDataFields(MetaDataType.TITLE, MetaDataType.ABSTRACT, MetaDataType.KEYWORDS);
searchtool.addBaseQueries(keywordQuery, softwareQuery, securityQuery);
searchtool.setBooleanOperatorType(BooleanOperatorType.AND);

String searchString = searchtool.generateSearchQuery(DatabaseType.ACM_DIGITIAL_LIBRARY);
logger.info("Created search String for ACM: {}", searchString);
```

First the keyword file ist loaded and parsed (depending on the amount of keywords, these need to be split into multiple queries because of boolean operator restrictions or URL length restrictions).

Next, three queries are generated.
The first one concatenates all the keywords with an "OR".
The second one concatenates the keywords "software" and "system" with an "OR".
The third query only contains the keyword "security".

Next, a SearchTool object is created.
It is specified, in which metadata fields the search is performed (e.g., Title, Abstract and Keywords fields).
Then the sub-queries are added to the searchtool and concatenated with an "AND" operator.

Now the searchquery can be automatically generated.

The generated search query can then be pasted into the respective advanced search fields of the databases.
In case of SpringerLink, the generated query can only search in Title and Keywords (by 31.07.2023) and be used only in conjunction with their official REST API.

### License

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
