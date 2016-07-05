package hnk.hu.androidapp;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.XMPPError;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {

    String msg = "Android : ";
    private XMPPConnection conn;
    private ConnectionConfiguration connectionConfiguration;
    private EditText loginName;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(msg, "The onCreate {} event");
        connectionConfiguration = new ConnectionConfiguration("192.168.0.103", 5222, "192.168.0.103");
        connectionConfiguration.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
        connectionConfiguration.setSASLAuthenticationEnabled(false);
        conn = new XMPPConnection(connectionConfiguration);
        SASLAuthentication.supportSASLMechanism("DIGEST-MD5", 0);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


    }

    /**
     * Called when the activity is about to become visible.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() event");
    }

    /**
     * Called when the activity has become visible.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event");
    }

    /**
     * Called when another activity is taking focus.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event");
    }

    /**
     * Called when the activity is no longer visible.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event");
    }

    /**
     * Called just before the activity is destroyed.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }

    public void buttonClick(View view) {
        Button button = (Button) view;
        Log.d(msg, "is connected:" + conn.isConnected());
        if (conn.isConnected()) {
            Message msg = new Message();
            String to = ((EditText) findViewById(R.id.toMsg)).getText().toString();
            String message = ((EditText) findViewById(R.id.msgText)).getText().toString();
            msg.setTo(to);
            msg.setBody(message);
            conn.sendPacket(msg);
            makeText(this, "Message sent successfuly.", Toast.LENGTH_LONG).show();
        }

    }

    public void makeConnection(View view) {
        Button button = (Button) view;
        loginName = (EditText) findViewById(R.id.loginName);
        password = (EditText) findViewById(R.id.password);
        Log.d(msg, "is connected:" + conn.isConnected());

        if (!conn.isConnected()) {
            try {
                conn.connect();
                makeText(this, "Connected to OpenFire server.", Toast.LENGTH_LONG).show();
            } catch (XMPPException | VerifyError e) {
                makeText(this, "Could not establish connection to OpenFire server.", Toast.LENGTH_LONG).show();
            }
        }

        if (!conn.isAuthenticated())
            try {

                Log.d(msg, "Username:" + loginName.getText().toString());
                Log.d(msg, "pass:" + password.getText().toString());
                conn.login(loginName.getText().toString(), password.getText().toString());
                makeText(this, "Connected to OpenFire with XMPP Smack API.", Toast.LENGTH_LONG).show();
                Presence presence = new Presence(Presence.Type.available);
                conn.sendPacket(presence);
                view.setEnabled(false);

            } catch (XMPPException | VerifyError e) {
                makeText(this, "Something wrong happened.", Toast.LENGTH_LONG).show();
                Log.d(msg, e.getMessage());
            }
    }

    public void disconnect(View view) {
        if (conn.isAuthenticated()) {
            Presence presence = new Presence(Presence.Type.unavailable);
            conn.sendPacket(presence);
            conn.disconnect();
            makeText(this, "Disconnected successfuly.", Toast.LENGTH_LONG).show();
            findViewById(R.id.connect).setEnabled(true);
        }
    }
}



