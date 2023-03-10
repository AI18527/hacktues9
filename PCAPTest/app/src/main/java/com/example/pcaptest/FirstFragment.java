package com.example.pcaptest;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.pcaptest.databinding.FragmentFirstBinding;

//import com.example.pcap.emanuelef.remote_capture.activities.CaptureCtrl;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private TextView showCountTextView;

    private final ActivityResultLauncher<Intent> captureLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), this::handleCaptureResult);

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);

        // Inflate the layout for this fragment
        View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);
        // Get the count text view
        showCountTextView = fragmentFirstLayout.findViewById(R.id.textview_first);

        return fragmentFirstLayout;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                // Get the value of the text view
//                String countString = showCountTextView.getText().toString();
//                // Convert value to a number and increment it
//                Integer count = Integer.parseInt(countString);
//                count++;
////                count = CaptureCtrl.inc(count);
//                // Display the new value in the text view.
//                showCountTextView.setText(count.toString());
                startCapture();
            }
        });

        view.findViewById(R.id.button_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopCapture();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    void startCapture() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setClassName("com.emanuelef.remote_capture", "com.emanuelef.remote_capture.activities.CaptureCtrl");

        intent.putExtra("action", "start");
        intent.putExtra("pcap_dump_mode", "udp_exporter");
        intent.putExtra("collector_ip_address", "127.0.0.1");
        intent.putExtra("collector_port", "5123");
        intent.putExtra("app_filter", "org.mozilla.firefox");

        captureLauncher.launch(intent);
    }

    void stopCapture() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setClassName("com.emanuelef.remote_capture", "com.emanuelef.remote_capture.activities.CaptureCtrl");

        intent.putExtra("action", "stop");
        intent.putExtra("pcap_dump_mode", "udp_exporter");
        intent.putExtra("collector_ip_address", "127.0.0.1");
        intent.putExtra("collector_port", "5123");
        intent.putExtra("app_filter", "org.mozilla.firefox");

        captureLauncher.launch(intent);
    }

    void handleCaptureResult(final ActivityResult result) {
        if(result.getResultCode() == RESULT_OK) {
            // command executed successfully
            Log.d("ok", "ok");
        }
    }
}