package at.jku.scsl.searchtool;

import at.jku.scsl.searchtool.types.BooleanOperatorType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class BaseQuery {

    private static final Logger logger = LogManager.getLogger(BaseQuery.class);
    private List<String> keywordList;
    private BooleanOperatorType booleanOperatorType;

    public BaseQuery() {
        this.keywordList = new ArrayList<>();
    }

    public void addKeyword(String keyword) {
        this.keywordList.add(keyword);
    }

    public List<String> getKeywordList() {
        return keywordList;
    }

    public void setKeywordList(List<String> keywordList) {
        this.keywordList = keywordList;
    }

    public BooleanOperatorType getBooleanOperatorType() {
        return booleanOperatorType;
    }

    public void setBooleanOperatorType(BooleanOperatorType booleanOperatorType) {
        if (keywordList.isEmpty()) {
            logger.error("Cannot set boolean operator if keywords are empty!");
            return;
        }
        this.booleanOperatorType = booleanOperatorType;
    }
}
