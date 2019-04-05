package com.example.cy5962.simpleadapter_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;

public class MainActivity extends AppCompatActivity {

    String [] animalname=new String[]{"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    //创建Listname
    int [] images = new int[] {R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    //选择Listimage
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建List合集，元素是Map
        List<Map<String,Object>> listItems=new ArrayList<Map<String,Object>>();
        for(int i=0;i<animalname.length;i++)
        {
            Map<String,Object> listItem=new HashMap<String,Object>();
            listItem.put("name",animalname[i]);
            listItem.put("image",images[i]);
            listItems.add(listItem);
        }
        //创建SimpleAdapter
        SimpleAdapter sim=new SimpleAdapter(this,listItems,R.layout.item,
                new String[] {"name","image"}, new int[]{R.id.name ,R.id.header});
        ListView l=(ListView)findViewById(R.id.listView);
        l.setAdapter(sim);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView parent, View view,int position,long id){
                Toast.makeText(MainActivity.this,animalname[position],Toast.LENGTH_LONG).show();
            }
        });
    }

}
