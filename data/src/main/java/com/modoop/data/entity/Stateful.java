package com.modoop.data.entity;

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
     * 状态：关闭
     */
    int CLOSED = 1;

    /**
     * 状态的 KEY
     */
    String[] TEXT = new String[]
    {
        "正常",
        "关闭"
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