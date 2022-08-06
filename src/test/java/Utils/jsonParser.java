package Utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//This class is will return the jsonobject which can be use to get the value;
public class jsonParser {
    String fileLocation;
    public jsonParser(String fileLocation) {
    this.fileLocation=fileLocation;
    }

    public JSONObject getParserObject() throws IOException, ParseException {
        //creating json parser
        JSONParser jsonParser=new JSONParser();
        //parsing the content of json file
        JSONObject jsonObject=(JSONObject) jsonParser.parse(new FileReader(fileLocation));


        return jsonObject;

    }
}
