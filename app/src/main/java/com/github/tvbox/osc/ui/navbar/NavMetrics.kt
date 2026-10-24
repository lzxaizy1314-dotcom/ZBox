package com.github.tvbox.osc.ui.navbar

import com.github.tvbox.osc.ui.WindowWidthClass

object NavMetrics {

    const val SURFACE_RAIL_WIDTH_DP = 80

    fun axisFor(widthClass: WindowWidthClass): NavAxis =
        if (widthClass == WindowWidthClass.Compact) NavAxis.Horizontal else NavAxis.Vertical

    fun actionSlotFor(tabCount: Int): Int = tabCount / 2

    // ZBox 二开：液态玻璃悬浮导航已删除，只剩实色导航——横向由 Scaffold 底栏占位（预留 0），
    // 纵向（宽屏）为左侧 NavigationRail 的宽度。
    fun reserveDp(axis: NavAxis): Int =
        if (axis == NavAxis.Vertical) SURFACE_RAIL_WIDTH_DP else 0
}
