package dplanner.anew.cap.mydplanner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Di M on 2017-05-16.
 */

public class PlanListView extends Fragment{

    PlanListAdapter adapter ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Adapter 생성 및 Adapter 지정.
        View view = inflater.inflate(R.layout.listfragment, null);
        ListView listView = (ListView)view.findViewById(R.id.listView);
        adapter = new PlanListAdapter();
        listView.setAdapter(adapter);

        /**생성시 데이터베이스에서 불러오기.**/
        adapter.addItem("9:00","10:00",
                "공부", "뇌자바 9장까지보기") ;
        adapter.addItem("11:00","12:00",
                "코딩", "알고리즘 문제 2개풀기") ;
        adapter.addItem("13:00","14:00",
                "약속", "친구 만나기") ;
        /*****/

        /**0522 변경사항 **/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),adapter.listViewItemList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                DialogController  dc= new DialogController();
                dc.getDesc(adapter.listViewItemList.get(position).getDesc());
                dc.show(getActivity().getFragmentManager(),"test");//,show() 메소드에는 fragmentmanager가 필요
            }
        });
        /*****/
        return view;
    }

    public void addItem(String starttime,String endtime, String title, String desc) {
        adapter.addItem(starttime,endtime, title, desc) ;
    }

}
