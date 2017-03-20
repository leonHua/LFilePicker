package com.leon.lfilepickerlibrary.ui;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.leon.lfilepickerlibrary.R;
import com.leon.lfilepickerlibrary.adapter.PathAdapter;
import com.leon.lfilepickerlibrary.utils.FileUtils;
import com.leon.lfilepickerlibrary.widget.EmptyRecyclerView;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class LFilePickerActivity extends AppCompatActivity {

    private final String TAG = "FilePickerLeon";
    private EmptyRecyclerView mRecylerView;
    private View mEmptyView;
    private TextView mTvPath;
    private TextView mTvBack;
    private Button mBtnAddBook;
    private String mPath;
    private List<File> mListFiles;
    private List<String> mListNumbers = new ArrayList<String>();//存放选中条目的数据地址
    private PathAdapter mPathAdapter;
    private FileFilter mFilter = new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            return pathname.isDirectory() || pathname.getName().endsWith(".txt") || pathname.getName().endsWith(".TXT");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lfile_picker);
        //startActivity(new Intent(this,Main2Activity.class));
        initView();
        if (!checkSDState()) {
            Toast.makeText(this, "没有发现可用存储", Toast.LENGTH_SHORT).show();
            return;
        }
        //mPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        mPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        mTvPath.setText(mPath);
        mListFiles = getFileList(mPath);
        mPathAdapter = new PathAdapter(mListFiles, this, mFilter);
        mRecylerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecylerView.setAdapter(mPathAdapter);
        mRecylerView.setmEmptyView(mEmptyView);
        initListener();

    }

    /**
     * 添加点击事件处理
     */
    private void initListener() {
        // 返回目录上一级
        mTvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempPath = new File(mPath).getParent();
                if (tempPath == null) {
                    return;
                }
                mPath = tempPath;
                mListFiles = getFileList(mPath);
                mPathAdapter.setmListData(mListFiles);
                mPathAdapter.notifyDataSetChanged();
                mRecylerView.scrollToPosition(0);
                setShowPath(mPath);
                //清除添加集合中数据
                mListNumbers.clear();
                mBtnAddBook.setText("放入书架");
            }
        });
        mPathAdapter.setOnItemClickListener(new PathAdapter.OnItemClickListener() {
            @Override
            public void click(int position) {
                if (mListFiles.get(position).isDirectory()) {
                    //如果当前是目录，则进入继续查看目录
                    mPath = mListFiles.get(position).getAbsolutePath();
                    setShowPath(mPath);
                    //更新数据源
                    mListFiles = getFileList(mPath);
                    mPathAdapter.setmListData(mListFiles);
                    mPathAdapter.notifyDataSetChanged();
                    mRecylerView.scrollToPosition(0);
                } else {
                    //如果已经选择则取消，否则添加进来
                    if (mListNumbers.contains(mListFiles.get(position).getAbsolutePath())) {
                        mListNumbers.remove(mListFiles.get(position).getAbsolutePath());
                    } else {
                        mListNumbers.add(mListFiles.get(position).getAbsolutePath());
                    }
                    mBtnAddBook.setText("放入书架( " + mListNumbers.size() + " )");
                }
            }
        });

        mBtnAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListNumbers.size() < 1) {
                    Toast.makeText(LFilePickerActivity.this, R.string.NotFoundBooks, Toast.LENGTH_SHORT).show();
                } else {
                    //返回
                    Toast.makeText(LFilePickerActivity.this, "选择的数量：" + mListNumbers.size(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * 根据地址获取当前地址下的所有目录和文件，并且排序
     *
     * @param path
     * @return List<File>
     */
    private List<File> getFileList(String path) {
        File file = new File(path);
        List<File> list = FileUtils.getFileListByDirPath(path, mFilter);
        return list;
    }

    /**
     * 初始化控件
     */
    private void initView() {
        mRecylerView = (EmptyRecyclerView) findViewById(R.id.recylerview);
        mTvPath = (TextView) findViewById(R.id.tv_path);
        mTvBack = (TextView) findViewById(R.id.tv_back);
        mBtnAddBook = (Button) findViewById(R.id.btn_addbook);
        mEmptyView = findViewById(R.id.empty_view);
    }

    /**
     * 检测SD卡是否可用
     */
    private boolean checkSDState() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 显示顶部地址
     *
     * @param path
     */
    private void setShowPath(String path) {
        mTvPath.setText(path);
    }
}
