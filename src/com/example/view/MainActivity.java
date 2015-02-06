package com.example.view;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bouncelistview.R;
import com.example.view.MyBounceScrollView.OnHeaderRefreshListener;


public class MainActivity extends ActionBarActivity implements OnHeaderRefreshListener{

	private ImageView mBackgroundImageView = null;
	private Button mLoginButton = null;
	private MyBounceScrollView mScrollView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initListView();
		
	}
	private void initListView() {
		 BounceListView mBounceListView = (BounceListView)findViewById(R.id.list);  
		 mBounceListView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getData()));  
	}
	private List<String> getData(){  
        
        List<String> data = new ArrayList<String>();  
        data.add("测试数据1");  
        data.add("测试数据2");  
        data.add("测试数据3");  
        data.add("测试数据4");  
        data.add("测试数据5");  
        data.add("测试数据6");  
        data.add("测试数据7");  
//        data.add("测试数据8");  
//        data.add("测试数据9");  
//        data.add("测试数据10");  
//        data.add("测试数据11");  
//        data.add("测试数据12");  
//        data.add("测试数据13");  
        return data;  
    }  
	private void initScrollView() {
		
		mBackgroundImageView = (ImageView) findViewById(R.id.personal_background_image);
		mLoginButton = (Button) findViewById(R.id.personal_login_button);
		mLoginButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "登录", 1).show();
			}
		});
		mScrollView = (MyBounceScrollView) findViewById(R.id.personal_scrollView);
		mScrollView.setImageView(mBackgroundImageView);
		mScrollView.setOnHeaderRefreshListener(this);
	}
	@Override
	public void onHeaderRefresh(MyBounceScrollView view) {
		Toast.makeText(getApplicationContext(), "刷新", 1).show();
	}
}
