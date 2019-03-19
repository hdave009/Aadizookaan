package com.harshdave.aadizookaan;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<String> mBooktitles = new ArrayList<>();
    private ArrayList<Drawable> mCoverimages = new ArrayList<>();
    private Context mContext;
    private HashMap<String, String[]> fileInfo = new HashMap<String, String[]>();


    public RecyclerViewAdapter(ArrayList<String> booktitle, ArrayList<Drawable> coverimage, Context context){
        mBooktitles = booktitle;
        mCoverimages = coverimage;
        mContext = context;
        fileInfo.put("Gluscabi and the Wind Eagle", new String[] {"Gluscabi and the Wind Eagle", "gluscabi.pdf", "13"});
        fileInfo.put("How Glooscap Found the Summer", new String[] {"How Glooscap Found the Summer", "glooscapfoundsummer.pdf", "6"});
        fileInfo.put("How the Buffalo Were Released On Earth", new String[] {"How the Buffalo Were Released On Earth","buffaloreleasedonearth.pdf", "6"});
        fileInfo.put("How the Milky Way Came to Be", new String[] {"How the Milky Way Came to Be", "howthemilkywaybecametobecherokee.pdf", "3"});
        //fileInfo.put("The Man Who Acted as The Sun", new String[] {"The Man Who Acted as The Sun", "themanwhoactedasthesun.pdf", "4"});
        fileInfo.put("How Gluskabe Stole Tobacco", new String[] {"How Gluskabe Stole Tobacco", "How Gluskabe Stole Tobacco.pdf", "9"});
        fileInfo.put("Indian Summer", new String[] {"Indian Summer", "Indian Summer.pdf","4"});
        fileInfo.put("The Origin of the Thunderbird", new String[] {"The Origin of the Thunderbird","The Origin of the Thunderbird.pdf","3"});
        fileInfo.put("The Dream Fast", new String[] {"The Dream Fast", "thedreamfastojibway.pdf","6"});
        fileInfo.put("The Great Flood of Ottawa", new String[] {"The Great Flood of Ottawa","thegreatfloodottawa.pdf","5"});
        fileInfo.put("White Owl and His Escape from the Witches and the Great Beasts", new String[]{"White Owl and His Escape from the Witches and the Great Beasts","White Owl and His Escape from the Witches and the Great Beasts.pdf","7"});
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) { ;

        viewHolder.coverimage.setImageDrawable(mCoverimages.get(i));

        viewHolder.booktitle.setText(mBooktitles.get(i));
        viewHolder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeIntent(fileInfo.get(mBooktitles.get(i)));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mBooktitles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView coverimage;
        TextView booktitle;
        RelativeLayout parent_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            coverimage = itemView.findViewById(R.id.coverimage);
            booktitle = itemView.findViewById(R.id.booktitle);
            parent_layout = itemView.findViewById(R.id.parent_layout);
        }

    }

    public void makeIntent(String[] fileInfo){
        String fileName = fileInfo[1];
        String storyTitle = fileInfo[0];
        String lastPage = fileInfo[2];
        Intent intent = new Intent(mContext, Gluscabi_and_the_Wind_Eagle.class);
        intent.putExtra("FILENAME", fileName);
        intent.putExtra("LASTPAGE", lastPage);
        intent.putExtra("FIRSTPAGE", "1");
        intent.putExtra("TITLE", storyTitle);
        mContext.startActivity(intent);

    }

}
