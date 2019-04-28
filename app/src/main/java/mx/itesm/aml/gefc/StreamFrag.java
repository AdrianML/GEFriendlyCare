package mx.itesm.aml.gefc;


import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class StreamFrag extends Fragment {

    VideoView video;


    public StreamFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_stream, container, false);

        video = v.findViewById(R.id.vvStream);

        Uri uri = Uri.parse("http://www.foreignhelper.com.mx/multimedia/Incubadora.mp4");

        video.setMediaController(new MediaController(getContext()));
        video.setVideoURI(uri);
        video.requestFocus();
        video.start();


        return  v;
    }

}
