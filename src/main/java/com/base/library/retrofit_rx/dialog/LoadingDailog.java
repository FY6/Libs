package com.base.library.retrofit_rx.dialog;

import android.content.Context;

import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.base.library.R;



/**
 * 进度加载框
 *
 * @author WZG
 */
public class LoadingDailog extends BaseDialog {
	private GifDrawable gifFromAssets;

	public LoadingDailog(Context context) {
		super(context, R.style.progress_dialog, false);
		init(R.layout.dialog_loading);
	}

	@Override
	protected void initResource() {
	}

	@Override
	protected void initWidget() {
//		GifImageView img = findViewById(R.id.img);
//		try {
//			gifFromAssets = new GifDrawable(getContext().getAssets(), "loading.gif");
//			img.setBackground(gifFromAssets);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public void show() {
		super.show();
		gifFromAssets.start();
	}

	@Override
	public void dismiss() {
		super.dismiss();
		gifFromAssets.stop();
	}
}
