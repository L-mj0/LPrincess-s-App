package com.example.lprincesssbloglimengjueroe21005;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ChannelAdapterROE21005 extends BaseAdapter {
    

    private final ArrayList<ChannelROE21005> channelListlimengjue;
    private final LayoutInflater layoutInflaterlimengjue;

    public ChannelAdapterROE21005(ArrayList<ChannelROE21005> listlimengjue, Context contextlimengjue){
        channelListlimengjue = listlimengjue;
        layoutInflaterlimengjue = LayoutInflater.from(contextlimengjue);
    }

    @Override
    public int getCount() {
        return channelListlimengjue.size();
    }

    @Override
    public Object getItem(int positionlimengjue) {
        return channelListlimengjue.get(positionlimengjue);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int positionlimengjue, View convertViewlimengjue, ViewGroup parentlimengjue) {

        ViewHolder holderlimengjue = null;

        if(convertViewlimengjue == null) {
            //加载布局
            convertViewlimengjue = layoutInflaterlimengjue.inflate(R.layout.grid_item_roe21005, null);

            holderlimengjue = new ViewHolder();
            holderlimengjue.imgChannellimengjue = (ImageView) convertViewlimengjue.findViewById(R.id.channel_img);
            holderlimengjue.decChannellimengjue = (TextView) convertViewlimengjue.findViewById(R.id.channel_dec);
            convertViewlimengjue.setTag(holderlimengjue);
        }else{
            holderlimengjue = (ViewHolder) convertViewlimengjue.getTag();
        }

        // 设置图标和文字
        ChannelROE21005 channel= (ChannelROE21005) channelListlimengjue.get(positionlimengjue);
        if(channel!=null){
            holderlimengjue.decChannellimengjue.setText(channel.getDec());
            switch (channel.getDec()){
                case "Introduction":
                    holderlimengjue.imgChannellimengjue.setImageResource(R.drawable.image1);
                    break;
                case "Blog~":
                    holderlimengjue.imgChannellimengjue.setImageResource(R.drawable.image2);
                    break;
                case "Github~":
                    holderlimengjue.imgChannellimengjue.setImageResource(R.drawable.image3);
                    break;
                case "Minesweeper":
                    holderlimengjue.imgChannellimengjue.setImageResource(R.drawable.image4);
                    break;
                case "Reversi":
                    holderlimengjue.imgChannellimengjue.setImageResource(R.drawable.image5);
                    break;
                case "Overview":
                    holderlimengjue.imgChannellimengjue.setImageResource(R.drawable.image6);
                    break;
                case "外网链接":
                    holderlimengjue.imgChannellimengjue.setImageResource(R.drawable.image7);
                    break;
                case "bilibili":
                    holderlimengjue.imgChannellimengjue.setImageResource(R.drawable.image8);
                    break;
                case "给我建议~":
                    holderlimengjue.imgChannellimengjue.setImageResource(R.drawable.image9);
                    break;
            }
        }
        return convertViewlimengjue;
    }
    class ViewHolder{
        ImageView imgChannellimengjue;
        TextView decChannellimengjue;
    }

}
