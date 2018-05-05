package com.xiaoxing.mvp_core.base;

import com.xiaoxing.mvp_core.data.repository.Repository;

/**
 * Created by hpw on 16/11/1.
 */

public class CoreBaseRepository {
    @Override
    public Object clone() {
        Repository stu = null;
        try {
            stu = (Repository) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return stu;
    }
}
