package dplanner.anew.cap.mydplanner;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Kyu on 2017-05-19.
 */

public class DialogController extends DialogFragment {

    private String desc;
   public void getDesc(String desc){
       this.desc = desc;
   }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        View view = inflater.inflate(R.layout.custom_dialog,null);
        TextView descView = (TextView)view.findViewById(R.id.custom_plan);
        Button complete_btn = (Button)view.findViewById(R.id.plan_complete);
        /**새 액티비티 생성**/
        complete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),test1.class);
                startActivity(intent);
            }
        });

        descView.setText(desc);
        return view;
    }

}
