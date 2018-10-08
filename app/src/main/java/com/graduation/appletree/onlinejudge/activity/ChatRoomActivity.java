package com.graduation.appletree.onlinejudge.activity;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.adapter.RVChatSendAdapter;
import com.graduation.appletree.onlinejudge.bean.RVChatRoomData;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;
import com.graduation.appletree.onlinejudge.utils.NetRequestUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Subscriber;

/**
 * ChatRoom
 *
 * @author lucas
 * @date 2018/3/21
 */
public class ChatRoomActivity extends BaseActivity{
    @BindView(R.id.titlebar_back)
    protected ImageView titlebar_back;
    @BindView(R.id.chat_room_name)
    protected TextView chat_room_name;
    @BindView(R.id.rv_chat_room_send)
    protected RecyclerView rv_chat_room_send;
    @BindView(R.id.rv_chat_room_accept)
    protected RecyclerView rv_chat_room_accept;
    @BindView(R.id.chat_room_input_send)
    protected ImageView chat_room_input_send;
    @BindView(R.id.chat_room_input)
    protected EditText chat_room_input;

    List<RVChatRoomData> mDataList = new ArrayList<>();
    RVChatSendAdapter mRVChatSendAdapter;
    int i = 0;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_chat_room;
    }

    @Override
    protected void initViewAndEvent() {
        initView();
        initRecoView();
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }

    @Override
    protected Context getContext() {
        return this;
    }

    @OnClick(R.id.chat_room_input_send)
    public void sendText(){
        final String text = chat_room_input.getText().toString();
        mRVChatSendAdapter.addData(1, text, i++);
    }

    /**
     * Instance Method
     * */

    private void initView(){
        titlebar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatRoomActivity.this.finish();
            }
        });
        chat_room_name.setText(getIntent().getExtras().getString("name"));
    }

    private void initRecoView(){
        mRVChatSendAdapter = new RVChatSendAdapter(getContext(),getDataList());
        rv_chat_room_send.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_chat_room_send.setAdapter(mRVChatSendAdapter);
    }

    private List<RVChatRoomData> getDataList(){
        return mDataList;
    }


}