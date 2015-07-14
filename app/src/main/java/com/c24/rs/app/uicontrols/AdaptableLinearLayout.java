package com.c24.rs.app.uicontrols;
import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

public class AdaptableLinearLayout extends LinearLayout {

    private BaseAdapter mAdapter;

    private int itemCount = 0;

    private boolean disableChildrenWhenDisabled = false;

    private int widthMeasureSpec;
    private int heightMeasureSpec;

    private AdapterView.OnItemClickListener mOnItemClickListener;

    public AdaptableLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseAdapter getAdapter() {
        return mAdapter;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public void setAdapter(BaseAdapter adapter) {
        mAdapter = adapter;
        adapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                updateLayout();
                super.onChanged();
            }

            @Override
            public void onInvalidated() {
                updateLayout();
                super.onInvalidated();
            }
        });
        updateLayout();
    }

    private void updateLayout() {
        itemCount = mAdapter.getCount();
        requestLayout();
        invalidate();
    }

    /**
     * set size for the current View
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.widthMeasureSpec = widthMeasureSpec;
        this.heightMeasureSpec = heightMeasureSpec;

        removeAllViewsInLayout();
        for (int i = 0; i < itemCount; i++) {
            makeAndAddView(i);
        }
    }

    private View makeAndAddView(int position) {
        View child;

        // Nothing found in the recycler -- ask the adapter for a view
        child = mAdapter.getView(position, null, this);

        // Position the view
        setUpChild(child, position);

        return child;

    }

    private void setUpChild(View child, final int position) {
        ViewGroup.LayoutParams lp = child.getLayoutParams();
        if (lp == null) {
            lp = generateDefaultLayoutParams();
        }

        child.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(null, v, position, 0);
                }
            }
        });

        addViewInLayout(child, position, lp);

        // Get measure specs
        int childHeightSpec = ViewGroup.getChildMeasureSpec(heightMeasureSpec, getPaddingTop() + getPaddingBottom(), lp.height);
        int childWidthSpec = ViewGroup.getChildMeasureSpec(widthMeasureSpec, getPaddingLeft() + getPaddingRight(), lp.width);

        // Measure child
        child.measure(childWidthSpec, childHeightSpec);

        int childLeft;
        int childRight;

        // Position vertically based on gravity setting
        int childTop = getPaddingTop() + ((getMeasuredHeight() - getPaddingBottom() - getPaddingTop() - child.getMeasuredHeight()) / 2);
        int childBottom = childTop + child.getMeasuredHeight();

        int width = child.getMeasuredWidth();
        childLeft = 0;
        childRight = childLeft + width;

        child.layout(childLeft, childTop, childRight, childBottom);

        if (disableChildrenWhenDisabled) {
            child.setEnabled(isEnabled());
        }
    }
}