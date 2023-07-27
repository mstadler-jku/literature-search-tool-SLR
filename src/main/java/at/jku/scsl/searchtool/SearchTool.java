package at.jku.scsl.searchtool;

import at.jku.scsl.searchtool.types.BooleanOperatorType;
import at.jku.scsl.searchtool.types.DatabaseType;
import at.jku.scsl.searchtool.types.MetaDataType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchTool {

    private static final Logger logger = LogManager.getLogger(SearchTool.class);
    private List<BaseQuery> queryList;
    private BooleanOperatorType booleanOperatorType;
    private List<MetaDataType> metaDataFields;

    public SearchTool() {
        this.queryList = new ArrayList<>();

        this.metaDataFields = new ArrayList<>();
    }


    public void addMetaDataFields(MetaDataType... metaDataTypes) {
        Collections.addAll(this.metaDataFields, metaDataTypes);
    }


    public void setBooleanOperatorType(BooleanOperatorType booleanOperatorType) {
        this.booleanOperatorType = booleanOperatorType;
    }

    public void addBaseQueries(BaseQuery... queries) {
        Collections.addAll(this.queryList, queries);
    }

    public String generateSearchQuery(DatabaseType databaseType) {
        switch (databaseType) {
            case IEEE_XPLORE -> {
                return generateIEEESearchQuery();
            }
            case ACM_DIGITIAL_LIBRARY -> {
                return generateACMSearchQuery();
            }
            case SCOPUS -> {
            }
            case WEB_OF_SCIENCE -> {
            }
            case SPRINGER_LINK -> {
            }
            default -> logger.error("DatabaseType not implemented: {}", databaseType);
        }
        return "";
    }

    private String generateACMSearchQuery() {
        StringBuilder resultSB = new StringBuilder();
        int queryCounter = 0;
        for (BaseQuery baseQuery : this.queryList) {
            queryCounter++;
            StringBuilder querySB = new StringBuilder();
            querySB.append("(");
            int metaCounter = 0;
            for (MetaDataType metaDataType : this.metaDataFields) {
                metaCounter++;
                if (metaDataType == MetaDataType.TITLE) {
                    querySB.append("Title");
                } else if (metaDataType == MetaDataType.ABSTRACT) {
                    querySB.append("Abstract");
                } else if (metaDataType == MetaDataType.KEYWORDS) {
                    querySB.append("Keyword");
                }
                querySB.append(":").append("(");
                int keywordCounter = 0;
                for (String keyword : baseQuery.getKeywordList()) {
                    keywordCounter++;
                    querySB.append("\"").append(keyword).append("\"");
                    if (keywordCounter != baseQuery.getKeywordList().size()) {
                        querySB.append(" ").append(baseQuery.getBooleanOperatorType()).append(" ");
                    }
                }
                querySB.append(")");
                if (metaCounter != this.metaDataFields.size()) {
                    querySB.append(" ").append(baseQuery.getBooleanOperatorType()).append(" ");
                }
            }
            querySB.append(")");
            if (queryCounter != this.queryList.size()) {
                querySB.append(" ").append(this.booleanOperatorType).append(" ");
            }
            resultSB.append(querySB);
        }
        return resultSB.toString();
    }

    private String generateIEEESearchQuery() {
        StringBuilder resultSB = new StringBuilder();
        for (int i = 0; i < this.queryList.size(); i++) {
            BaseQuery baseQuery = this.queryList.get(i);
            StringBuilder querySB = new StringBuilder();
            querySB.append("(");
            for (int j = 0; j < baseQuery.getKeywordList().size(); j++) {
                String keyword = baseQuery.getKeywordList().get(j);
                for (MetaDataType metaDataType : this.metaDataFields) {
                    if (metaDataType == MetaDataType.TITLE) {
                        querySB.append("\"Document Title\":");
                    } else if (metaDataType == MetaDataType.ABSTRACT) {
                        querySB.append("\"Abstract\":");
                    } else if (metaDataType == MetaDataType.KEYWORDS) {
                        querySB.append("\"Index Terms\":");
                    }
                    querySB.append(keyword);
                    if (baseQuery.getBooleanOperatorType() != null) {
                        querySB.append(" ").append(baseQuery.getBooleanOperatorType()).append("\n\t");
                    }
                }
            }
            String queryAsString = querySB.toString();
            // remove last boolean operator
            if (baseQuery.getBooleanOperatorType() != null) {
                queryAsString = queryAsString.substring(0, queryAsString.length() - baseQuery.getBooleanOperatorType().charLength);
            }
            resultSB.append(queryAsString);
            resultSB.append(")");
            if (this.booleanOperatorType != null && (i + 1) < this.queryList.size()) {
                resultSB.append(" ").append(this.booleanOperatorType).append("\n\t");
            }
        }
        return resultSB.toString();
    }

    public void reset() {
        this.queryList = new ArrayList<>();
        this.booleanOperatorType = null;
        this.metaDataFields = new ArrayList<>();
    }
}
