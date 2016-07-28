package com.missdr.jun.test1;

import java.util.ArrayList;

/**
 * Created by jun on 7/28/16.
 * A Lyan template!
 */
public class MockedDB {

    public ArrayList<Post> getPosts(){
        ArrayList<Post> list = new ArrayList<>();
        for(int i=0;i<100;i++){
            list.add(new Post("author"+i, "description"+i , i*i));
        }
        return list;
    }
}
