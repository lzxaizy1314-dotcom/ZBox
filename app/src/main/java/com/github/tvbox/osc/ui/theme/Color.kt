package com.github.tvbox.osc.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.SelectableChipColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val ColorScheme.cardContainer: Color
    get() = surfaceBright

val SuccessGreen: Color = Color(0xFF4CAF50)

// ---- ZBox 二开 · 1 号「暖纸杂志风」主题 token ----
// 暖纸底、白圆角卡、单一暖橙点缀；浅色模式下整体覆盖到 Material 色板。
val PaperBackground: Color = Color(0xFFF6F1E7)
val PaperCard: Color = Color(0xFFFFFFFF)
val PaperCardAlt: Color = Color(0xFFFCF9F3)
val PaperInk: Color = Color(0xFF211D17)
val PaperAccent: Color = Color(0xFFC2571F)
val PaperAccentContainer: Color = Color(0xFFF7E3D2)
val PaperSeedArgb: Int = 0xFFC2571F.toInt()

fun ColorScheme.toWarmPaper(): ColorScheme = copy(
    background = PaperBackground,
    onBackground = PaperInk,
    surface = PaperBackground,
    onSurface = PaperInk,
    surfaceDim = Color(0xFFEDE5D5),
    surfaceBright = PaperCard,
    surfaceContainerLowest = PaperCard,
    surfaceContainerLow = PaperCard,
    surfaceContainer = PaperCardAlt,
    surfaceContainerHigh = Color(0xFFF3ECDD),
    surfaceContainerHighest = Color(0xFFEEE4D0),
    surfaceVariant = Color(0xFFF0E7D6),
    onSurfaceVariant = Color(0xFF6B6151),
    primary = PaperAccent,
    onPrimary = Color.White,
    primaryContainer = PaperAccentContainer,
    onPrimaryContainer = Color(0xFF6E2F0E),
    outline = Color(0xFFCBBFA7),
    outlineVariant = Color(0xFFE3D9C6),
    surfaceTint = PaperBackground,
)

fun ColorScheme.toPureBlack(): ColorScheme = copy(
    background = Color.Black,
    surface = Color.Black,
    surfaceDim = Color.Black,
    surfaceContainerLowest = Color.Black,
    surfaceContainer = Color.Black,
    surfaceContainerLow = Color(0xFF060606),
    surfaceContainerHigh = Color(0xFF0B0B0B),
    surfaceContainerHighest = Color(0xFF121212),
    surfaceBright = Color(0xFF141414),
    surfaceVariant = Color(0xFF1A1A1A),
    surfaceTint = Color.Black,
)

@Composable
fun ColorScheme.filterChipColors(containerColor: Color = Color.Transparent): SelectableChipColors =
    FilterChipDefaults.filterChipColors(
        containerColor = containerColor,
        selectedContainerColor = primaryContainer,
        selectedLabelColor = onPrimaryContainer,
    )
