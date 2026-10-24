package com.github.tvbox.osc.ui.components

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

// ZBox 二开：液态玻璃已整体移除。顶栏与控件统一走实色底（fallbackColor 即最终底色），
// 保留原函数签名与文件名，调用方（顶栏圆形按钮、搜索框、配置页圆形钮等）无需改动。
// pressEffect 参数仅为兼容旧调用保留，不再有任何按压光效与图层录制。
fun Modifier.glassTopBarSurface(
    shape: Shape,
    fallbackColor: Color,
    pressEffect: Boolean = true,
): Modifier = this.clip(shape).background(fallbackColor)

fun Modifier.glassSurface(
    shape: Shape,
    fallbackColor: Color,
    pressEffect: Boolean = true,
): Modifier = this.clip(shape).background(fallbackColor)
