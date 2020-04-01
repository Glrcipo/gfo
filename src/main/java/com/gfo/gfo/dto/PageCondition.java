package com.gfo.gfo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 公共基础-分页查询传输对象
 *
 * @author huanglw
 * @date 2019-4-27
 */
@Setter
@Getter
public class PageCondition {

    /**
     * 当前页数
     */
    private Integer page;

    /**
     * 每页展示条数
     */
    private Integer pageSize;

    /**
     * 总条数
     */
    private Long total;

    /**
     * 排序字段名称
     */
    private String sort;

    /**
     * 排序类型
     */
    private String order;


    public enum OrderEnum {

        DESC("DESC"),
        ASC("ASC"),;

        private String code;

        public String getCode() {
            return code;
        }

        OrderEnum(String code) {
            this.code = code;
        }

        /**
         * 根据编号获得是倒序还是正序，如果都不是，默认返回 DESC
         *
         * @param code
         * @return
         */
        public static String getCode(String code) {
            OrderEnum[] orderEnums = OrderEnum.values();
            for (OrderEnum orderEnum : orderEnums) {
                if (orderEnum.getCode().equals(code)) {
                    return orderEnum.getCode();
                }
            }
            return OrderEnum.DESC.getCode();
        }
    }
}
