package xyz.yluo.ruisiapp.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import xyz.yluo.ruisiapp.App;
import xyz.yluo.ruisiapp.R;
import xyz.yluo.ruisiapp.activity.BaseActivity;


/**
 * A simple {@link Fragment} subclass.
 */

public abstract class BaseFragment extends Fragment {
    protected View mRootView;
    protected View toolBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(null == mRootView){
            mRootView = inflater.inflate(getLayoutId(), container, false);
        }
        return mRootView;
    }

    protected void initToolbar(boolean isCloseAble,String title){
        toolBar = mRootView.findViewById(R.id.myToolBar);
        if(toolBar!=null){
            TextView titles = (TextView) toolBar.findViewById(R.id.title);
            titles.setText(title);
            ImageView i = (ImageView) toolBar.findViewById(R.id.logo);
            if(isCloseAble){
                i.setImageResource(R.drawable.ic_arraw_back_white);
                i.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getActivity().finish();
                    }
                });
            }else{
                i.setVisibility(View.GONE);
            }
        }
    }

    protected ImageView addToolbarMenu(int resid){
        toolBar = mRootView.findViewById(R.id.myToolBar);
        if(toolBar!=null){
            ImageView i =  (ImageView)toolBar.findViewById(R.id.menu);
            i.setVisibility(View.VISIBLE);
            i.setImageResource(resid);
            return i;
        }
        return null;
    }

    protected ImageView setToolbarLogo(int resid){
        toolBar = mRootView.findViewById(R.id.myToolBar);
        if(toolBar!=null){
            ImageView i =  (ImageView)toolBar.findViewById(R.id.logo);
            i.setVisibility(View.VISIBLE);
            i.setImageResource(resid);
            return i;
        }
        return null;
    }


    protected abstract int getLayoutId();

    protected boolean isLogin() {
        return App.ISLOGIN(getActivity()) || ((BaseActivity) getActivity()).isLogin();
    }


    protected void switchActivity(Class<?> cls){
        getActivity().startActivity(new Intent(getActivity(),cls));
    }

}
