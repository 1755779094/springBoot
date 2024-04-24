package com.mjq.bigevent;


import com.mjq.bigevent.utils.JwtUtil;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


public class JwtTest {

    @Test
    void testParse(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id", "11");
        map.put("name", "1mjq");
        String token = JwtUtil.genToken(map);
        System.out.println(token);

        String tt = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ8." +
                "eyJjbGFpbXMiOnsibmFtZSI6IjFtanEi" +
                "LCJpZCI6IjExIn0sImV4cCI6MTcxMDUzMjg2Mn0." +
                "JHj5y2T33ciMliD1ZxZh63wWSGnX_DEUZJoUCtr3w2o";
        Map<String, Object> claims = JwtUtil.parseToken(tt);
        System.out.println(claims);


    }
}
