package dplanner.anew.cap.mydplanner;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Di M on 2017-05-12.
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    // Count number of tabs
    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        // Returning the current tabs
        switch (position) {
            case 0:
                PlanListView planListView = new PlanListView();
                return planListView;
            case 1:
                TabFragment2 tabFragment2 = new TabFragment2();
                return tabFragment2;
            case 2:
                CreatePlanView createPlanView = new CreatePlanView();
                return createPlanView;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
    public void setTabCount(int tabCount){this.tabCount = tabCount;}

}
