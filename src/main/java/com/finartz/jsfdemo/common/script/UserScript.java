package com.finartz.jsfdemo.common.script;

import java.util.HashMap;
import java.util.Map;

public class UserScript {

    public static final Map<String, String> USER_COLUMN_MAPPINGS;

    static {
        USER_COLUMN_MAPPINGS = new HashMap<>();

        USER_COLUMN_MAPPINGS.put("ID", "id");
        USER_COLUMN_MAPPINGS.put("first_name", "firstName");
        USER_COLUMN_MAPPINGS.put("last_name", "lastName");
        USER_COLUMN_MAPPINGS.put("phone", "phone");
    }
}
