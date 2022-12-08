package com.example.nestedrecyclearviewrevision;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.adaptorClasses.ChildAdaptor;
import com.example.adaptorClasses.ParentAdaptor;
import com.example.modelClasses.ChildModelClass;
import com.example.modelClasses.ParentModelClass;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String IMAGE_KAY = "imageKey";
    List<ParentModelClass> parentModelClassArrayList;
    List<ChildModelClass> childModelClassArrayList;
    RecyclerView rvParent;
    ParentAdaptor parentAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvParent=findViewById(R.id.rvParent);
        setAdaptor();
        //clickMethodOfChild();
        ChildAdaptor childAdaptor=new ChildAdaptor();
        childAdaptor.setChildClickListener(new ChildAdaptor.ChildClickListener() {
            @Override
            public void childClick(View view, int index) {
                int image=parentModelClassArrayList.get(index).getChildModelClassList().get(index).getImage();
                Intent intent=new Intent(MainActivity.this,Main3Activity.class);
                intent.putExtra(IMAGE_KAY,image);
                startActivity(intent);
            }
        });
    }
    private void setAdaptor(){
        parentAdaptor=new ParentAdaptor(data());
        rvParent.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
        rvParent.setHasFixedSize(true);
        rvParent.setAdapter(parentAdaptor);
    }
    List<ParentModelClass> data(){
        parentModelClassArrayList=new ArrayList<>();
        parentModelClassArrayList.add(new ParentModelClass("Recommended",childData1()));
        parentModelClassArrayList.add(new ParentModelClass("New",childData2()));
        parentModelClassArrayList.add(new ParentModelClass("Old Fashion",childData3()));
        parentModelClassArrayList.add(new ParentModelClass("Women's",childData4()));
        parentModelClassArrayList.add(new ParentModelClass("Men's",childData5()));
        parentModelClassArrayList.add(new ParentModelClass("Category",childData6()));
        parentModelClassArrayList.add(new ParentModelClass("Children",childData7()));
        parentModelClassArrayList.add(new ParentModelClass("Coming soon",childData8()));
        return parentModelClassArrayList;
    }
    List<ChildModelClass> childData1(){
        List<ChildModelClass> childModelClassArrayList=new ArrayList<>();
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe1));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe2));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe3));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe4));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe5));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe6));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe7));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe8));
        return childModelClassArrayList;
    }
    List<ChildModelClass> childData2(){
        childModelClassArrayList=new ArrayList<>();
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe2));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe4));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe3));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe1));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe7));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe8));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe7));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe5));
        return childModelClassArrayList;
    }
    List<ChildModelClass> childData3(){
        List<ChildModelClass> childModelClassArrayList=new ArrayList<>();
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe8));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe7));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe6));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe5));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe4));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe3));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe2));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe1));
        return childModelClassArrayList;
    }
    List<ChildModelClass> childData4(){
        List<ChildModelClass> childModelClassArrayList=new ArrayList<>();
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe7));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe6));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe5));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe4));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe3));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe2));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe1));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe8));
        return childModelClassArrayList;
    }
    List<ChildModelClass> childData5(){
        List<ChildModelClass> childModelClassArrayList=new ArrayList<>();
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe6));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe5));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe4));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe3));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe2));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe1));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe8));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe7));
        return childModelClassArrayList;
    }
    List<ChildModelClass> childData6(){
        List<ChildModelClass> childModelClassArrayList=new ArrayList<>();
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe5));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe4));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe3));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe2));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe1));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe8));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe7));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe6));
        return childModelClassArrayList;
    }
    List<ChildModelClass> childData7(){
        List<ChildModelClass> childModelClassArrayList=new ArrayList<>();
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe4));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe3));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe2));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe1));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe8));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe7));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe6));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe5));
        return childModelClassArrayList;
    }
    List<ChildModelClass> childData8(){
        List<ChildModelClass> childModelClassArrayList=new ArrayList<>();
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe3));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe2));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe1));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe8));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe7));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe6));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe5));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.shoe4));
        return childModelClassArrayList;
    }
}