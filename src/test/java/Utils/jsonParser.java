package Utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//This class is will return the jsonobject which can be use to get the value;
public class jsonParser {
    private static Logger LOGGER = LoggerFactory.getLogger(jsonParser.class);
    String fileLocation;
    public jsonParser(String fileLocation) {
    this.fileLocation=fileLocation;
    }

    public JSONObject getParserObject() throws IOException, ParseException {
        //creating json parser
        JSONParser jsonParser=new JSONParser();
        //parsing the content of json file
        LOGGER.debug("File Location is {}",fileLocation);
        JSONObject jsonObject=(JSONObject) jsonParser.parse(new FileReader(fileLocation));
        LOGGER.debug("JSONObject {} is created",jsonObject);

        return jsonObject;

    }
}
