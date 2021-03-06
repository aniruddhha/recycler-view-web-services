package com.melayer.recyclerview;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import com.melayer.dto.MeAdmin;
import com.melayer.dto.MeDevice;
import com.melayer.dto.MeInfo;
import com.melayer.model.MeDeviceModel;
import com.melayer.web.HttpRequest;
import com.melayer.web.JsonMan;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private MeAdapter adapter;

    private ArrayList<MeRecyclerItem> listItem = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MeAdapter(this,listItem);

        getDataFromServerSampleMethod();

        postDataToServerSampleMethod();

        initSwipers();

    }

    private void getDataFromServerSampleMethod(){

        //Get Data from web Server
        new MeGetAnyObject().execute("");
    }

    private void postDataToServerSampleMethod(){

        //Post data to any server
        MeDeviceModel deviceModel = new MeDeviceModel();
        deviceModel.setAdminId(70996l);
        deviceModel.setDateTimeStamp(System.currentTimeMillis());
        deviceModel.setDeviceId(11l);
        deviceModel.setDeviceImei("214455474364465");
        deviceModel.setDeviceMobileNumber("+91 999 994 2053");
        deviceModel.setDeviceUserName("Chanda");
        deviceModel.setDistrict("Pune");
        deviceModel.setIntervalTracking(1);
        deviceModel.setIsTrackingOn(true);
        deviceModel.setPushNotificationId("adfiuafjhjhhgjhgjhiafhu");

        new MePostAnyObjectTask<MeDeviceModel>("").execute(deviceModel);
    }

    private void initSwipers(){

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.RIGHT, ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                if (direction == ItemTouchHelper.RIGHT) {

                    Log.i(MainActivity.class.getCanonicalName(),""+viewHolder.getAdapterPosition());
                    adapter.removeItemFromRecycler(viewHolder.getAdapterPosition());

                    adapter.printListSize();
                }
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private class MeGetAnyObject extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {

            String data = HttpRequest.get(strings[0]).body();

            Log.i(MainActivity.class.toString(), "" + data);

            try {

                listItem = new ArrayList<>();
                MeAdmin admin = JsonMan.<MeAdmin>toObject(data, MeAdmin.class);
                Log.i(MainActivity.class.toString(), admin.toString());

                for (MeDevice device : admin.getRegisteredDevices()) {

                    MeRecyclerItem item = new MeRecyclerItem(device.getUserName(), android.R.drawable.btn_plus);
                    listItem.add(item);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            adapter.haveFreshDataset(listItem);
            recyclerView.setAdapter(adapter);

        }
    }

    private class MePostAnyObjectTask<REQ> extends AsyncTask<REQ, Void, String> {

        private String url;

        public MePostAnyObjectTask(String url) {
            super();

            this.url = url;
        }

        @Override
        protected String doInBackground(REQ... devices) {

            String requestJson = null;
            try {
                requestJson = JsonMan.<REQ>fromObject(devices[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }

            String responseJson = HttpRequest.post(url)
                    .accept("application/json")
                    .contentType("application/json")
                    .send(requestJson)
                    .body();

            Log.i(this.getClass().toString(), "Response from server " + responseJson);

            try {

                MeInfo info = JsonMan.<MeInfo>toObject(responseJson, MeInfo.class);
                Log.i(MePostAnyObjectTask.class.toString(), "" + info);

            } catch (Exception e) {
                e.printStackTrace();
            }

            return responseJson;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

        }
    }
}
