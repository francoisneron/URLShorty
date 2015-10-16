package main.shorty.business;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by NERF on 16/10/2015.
 */
public interface URLShortyService {

    /* if we want to use a db. Some refactors will be needed in the
    *  URLShorty class
    * */
    public void save(String key, String longURL);
    public void delete(String key);
    public void getKey(String longURL);
    public void getValue(String key);

    /* Mostly to use with file */
    public void saveAll(HashMap<String, String> keyToLongURL) throws IOException;
    public HashMap<String, String> loadAll() throws IOException;
}
