package com.modoop.admin.entity;

/**
 * @author Genkyo Lee
 */
public interface Stateful
{
    /**
     * 状态：正常
     */
    int NORMAL = 0;

    /**
     * 状态：暂停前预警期
     */
    int WARNING = 1;

    /**
     * 状态：暂停
     */
    int PAUSED = 2;

    /**
     * 状态：过期
     */
    int EXPIRED = 3;

    /**
     * 状态：初始待审
     */
    int OPEN = 4;

    /**
     * 状态：关闭
     */
    int CLOSED = 5;

    /**
     * 未设置/不限制/所有
     */
    int NA = -1;

    /**
     * 状态的 KEY
     */
    String[] TEXT = new String[]
    {
        "正常",
        "警告",
        "暂停",
        "过期",
        "初始待审",
        "关闭",
        "无限制"
    };

    /**
     * 得到状态.
     *
     * @return 状态值
     */
    Integer getState();

    /**
     * 设置状态.
     *
     * @param state 状态值
     */
    void setState(Integer state);

} // end interface