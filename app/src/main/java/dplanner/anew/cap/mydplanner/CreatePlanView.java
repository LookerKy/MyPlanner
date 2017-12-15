package dplanner.anew.cap.mydplanner;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Di M on 2017-05-12.
 */

public class CreatePlanView extends Fragment {
    private int end_hour ,start_hour,end_min,start_min;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        start_hour = Integer.parseInt(getHour());
        start_min = Integer.parseInt(getMin());
        View view = inflater.inflate(R.layout.tab_fragment_3,null);
        final TextView mnow_time = (TextView)view.findViewById(R.id.time_now);
        final TextView end_time = (TextView)view.findViewById(R.id.time_end) ;
        Button mstart_btn = (Button)view.findViewById(R.id.startT_btn);
        Button mend_btn = (Button)view.findViewById(R.id.endT_btn);
        Button create_plan = (Button)view.findViewById(R.id.make_plan);

        mnow_time.setText(getTime());
        mstart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog StartTime = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Toast.makeText(getContext(),hourOfDay+"시"+minute+"분",Toast.LENGTH_LONG).show();
                        mnow_time.setText(hourOfDay+"시"+minute+"분");
                        start_hour = hourOfDay;
                        start_min = minute;
                    }
                }, Integer.parseInt(getHour()), Integer.parseInt(getMin()), false);
                StartTime.show();
            }
        });
        mend_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog EndTime = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                        Toast.makeText(getContext(),hourOfDay+"시"+minute+"분",Toast.LENGTH_LONG).show();
//                        end_time.setText(hourOfDay+"시"+minute+"분");
                        end_hour = hourOfDay;
                        end_min = minute;
                        if(end_hour < start_hour){
                            Toast.makeText(getContext(),"설정 불가",Toast.LENGTH_LONG).show();
                        }
                        else if(end_hour == start_hour){
                            if(end_min <= start_min){
                                Toast.makeText(getContext(),"설정 불가",Toast.LENGTH_LONG).show();
                            }
                            else{ end_time.setText(hourOfDay+"시"+minute+"분");}
                        }else{
                            end_time.setText(hourOfDay+"시"+minute+"분");
                        }

                    }
                }, start_hour, start_min, false);
                EndTime.show();
            }
        });
        create_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //데이터베이스 저장(클래스 하나 생성) 후 1페이지로 넘어가게하기
            }
        });
        return view;
    }
    private String getTime(){
        // 현재시간을 msec 으로 구한다.
        long now = System.currentTimeMillis();
        // 현재시간을 date 변수에 저장한다.
        Date date = new Date(now);
        // 시간을 나타냇 포맷을 정한다 ( yyyy/MM/dd 같은 형태로 변형 가능 )
        SimpleDateFormat sdfNow = new SimpleDateFormat("HH시 mm분");
        // nowDate 변수에 값을 저장한다.
        String formatDate = sdfNow.format(date);
        return formatDate;
    }
    private String getHour(){
        // 현재시간을 msec 으로 구한다.
        long now = System.currentTimeMillis();
        // 현재시간을 date 변수에 저장한다.
        Date date = new Date(now);
        // 시간을 나타냇 포맷을 정한다 ( yyyy/MM/dd 같은 형태로 변형 가능 )
        SimpleDateFormat sdfNow = new SimpleDateFormat("HH");
        // nowDate 변수에 값을 저장한다.
        String formatDate = sdfNow.format(date);
        return formatDate;

    }
    private String getMin(){
        // 현재시간을 msec 으로 구한다.
        long now = System.currentTimeMillis();
        // 현재시간을 date 변수에 저장한다.
        Date date = new Date(now);
        // 시간을 나타냇 포맷을 정한다 ( yyyy/MM/dd 같은 형태로 변형 가능 )
        SimpleDateFormat sdfNow = new SimpleDateFormat("mm");
        // nowDate 변수에 값을 저장한다.
        String formatDate = sdfNow.format(date);
        return formatDate;

    }
}
