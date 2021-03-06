package com.walnutin.xtht.bracelet.mvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.RadioButton;

import com.rance.library.ButtonData;
import com.rance.library.ButtonEventListener;
import com.rance.library.SectorMenuButton;
import com.walnutin.xtht.bracelet.R;
import com.walnutin.xtht.bracelet.mvp.ui.adapter.FragmentViewPagerAdapter;
import com.walnutin.xtht.bracelet.mvp.ui.fragment.mvp.ui.fragment.EquipmentFragment;
import com.walnutin.xtht.bracelet.mvp.ui.fragment.mvp.ui.fragment.ExerciseFragment;
import com.walnutin.xtht.bracelet.mvp.ui.fragment.mvp.ui.fragment.MainFragment;
import com.walnutin.xtht.bracelet.mvp.ui.fragment.mvp.ui.fragment.MineFragment;
import com.walnutin.xtht.bracelet.mvp.ui.widget.ContainerViewPager;
import com.walnutin.xtht.bracelet.mvp.ui.widget.MyViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by suns on 2017-06-13.
 */

public class MainActivity extends FragmentActivity {
    @BindView(R.id.viewpager)
    ContainerViewPager viewpager;
    @BindView(R.id.radio_main)
    RadioButton radioMain;
    @BindView(R.id.radio_exerse)
    RadioButton radioExerse;
    @BindView(R.id.radio_equipment)
    RadioButton radioEquipment;
    @BindView(R.id.radio_mine)
    RadioButton radioMine;
    @BindView(R.id.bottom_sector_menu)
    SectorMenuButton bottom_sector_menu;
    //菜单
    private static final int[] ITEM_DRAWABLES = {R.mipmap.tj, R.mipmap.paobu, R.mipmap.jianshen,
            R.mipmap.qixin, R.mipmap.tubu};

    public static final int TAB_HOME = 0;
    public static final int TAB_EXERCISE = 1;
    public static final int TAB_EQUIPMENT = 2;
    public static final int TAB_MINE = 3;
    MainFragment mainfragment;
    ExerciseFragment exerciseFragment;
    MineFragment mineFragment;
    EquipmentFragment equipmentFragment;
    List<ButtonData> buttonDatas = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initView();
        addPageChangeListener();
        for (int i = 0; i < 5; i++) {
            ButtonData buttonData = ButtonData.buildIconButton(this, ITEM_DRAWABLES[i], 0);
            buttonData.setBackgroundColorId(this, R.color.add);
            buttonDatas.add(buttonData);
        }


        bottom_sector_menu.setButtonDatas(buttonDatas);
        setListener(bottom_sector_menu);
    }

    private void setListener(final SectorMenuButton button) {
        button.setButtonEventListener(new ButtonEventListener() {
            @Override
            public void onButtonClicked(int index) {

            }

            @Override
            public void onExpand() {

            }

            @Override
            public void onCollapse() {

            }
        });
    }

    private void initView() {
        List<Fragment> fragments = new ArrayList<Fragment>();
        mainfragment = new MainFragment();
        exerciseFragment = ExerciseFragment.newInstance();
        equipmentFragment = EquipmentFragment.newInstance();
        mineFragment = MineFragment.newInstance();
        fragments.add(mainfragment);
        fragments.add(exerciseFragment);
        fragments.add(equipmentFragment);
        fragments.add(mineFragment);
        this.viewpager.setOffscreenPageLimit(0);
        FragmentViewPagerAdapter adapter = new FragmentViewPagerAdapter(this.getSupportFragmentManager(), viewpager, fragments);


    }

    private void addPageChangeListener() {
        viewpager.setOnPageChangeListener(new MyViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int id) {
                switch (id) {
                    case TAB_HOME:
                        radioMain.setChecked(true);
                        break;
                    case TAB_EXERCISE:
                        radioExerse.setChecked(true);
                        break;
                    case TAB_EQUIPMENT:
                        radioEquipment.setChecked(true);
                        break;
                    case TAB_MINE:
                        radioMine.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    @OnClick({R.id.radio_main, R.id.radio_exerse, R.id.radio_equipment, R.id.radio_mine})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.radio_main:
                viewpager.setCurrentItem(TAB_HOME, false);
                break;
            case R.id.radio_exerse:
                viewpager.setCurrentItem(TAB_EXERCISE, false);
                break;
            case R.id.radio_equipment:
                viewpager.setCurrentItem(TAB_EQUIPMENT, false);
                break;
            case R.id.radio_mine:
                viewpager.setCurrentItem(TAB_MINE, false);
                break;
        }
    }


}
