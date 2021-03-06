package xyz.yluo.ruisiapp.activity;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import xyz.yluo.ruisiapp.R;
import xyz.yluo.ruisiapp.data.FrageType;
import xyz.yluo.ruisiapp.fragment.FragSetting;
import xyz.yluo.ruisiapp.fragment.FrageHelp;
import xyz.yluo.ruisiapp.fragment.FrageTopicStarHistory;

public class FragementActivity extends BaseActivity {

    public static void open(Context c, int type){
        Intent intent = new Intent(c, FragementActivity.class);
        intent.putExtra("TYPE",type);

        c.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout f =new FrameLayout(this);
        f.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        f.setId(R.id.container);
        setContentView(f);

        Fragment to = null;
        Bundle  b =  getIntent().getExtras();
        switch (b.getInt("TYPE")){
            case FrageType.TOPIC:
                to = FrageTopicStarHistory.newInstance(FrageType.TOPIC);
                break;
            case FrageType.START:
                to = FrageTopicStarHistory.newInstance(FrageType.START);
                break;
            case FrageType.HISTORY:
                to = FrageTopicStarHistory.newInstance(FrageType.HISTORY);
                break;
            case FrageType.HELP:
                to = new FrageHelp();
                break;
            case FrageType.SETTING:
                to = new FragSetting();
                break;
        }

        getFragmentManager().beginTransaction().replace(
                R.id.container,to).commit();
    }

}
