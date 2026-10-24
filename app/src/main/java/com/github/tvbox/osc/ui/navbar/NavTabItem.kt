package com.github.tvbox.osc.ui.navbar

// 自 FloatingNavBar.kt 拆出：玻璃导航栏删除后，导航轴向枚举与标签项数据类仍被
// MainScreen 的实色导航（ShortNavigationBar / NavigationRail 的直播入口）使用，独立保留。
enum class NavAxis { Horizontal, Vertical }

data class NavTabItem(
    val iconRes: Int,
    val label: String
)
