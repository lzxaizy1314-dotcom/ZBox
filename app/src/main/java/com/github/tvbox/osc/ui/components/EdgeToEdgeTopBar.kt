package com.github.tvbox.osc.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsIgnoringVisibility
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBarScaffold(
    titleContent: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.surfaceContainer,
    navigationIcon: (@Composable () -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    collapseEnabled: Boolean = true,
    topBarStartInset: Dp = 0.dp,
    topScrimEnabled: Boolean = true,
    content: @Composable androidx.compose.foundation.layout.BoxScope.(topPadding: androidx.compose.ui.unit.Dp, bottomPadding: androidx.compose.ui.unit.Dp) -> Unit,
) {
    val scrollBehavior = if (collapseEnabled) {
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    } else {
        TopAppBarDefaults.pinnedScrollBehavior()
    }
    // ZBox 二开：顶栏不再录制 backdrop 做液态玻璃底，栏体透明、直接透出 Scaffold 实色底，
    // 左上角按钮等控件走 glassTopBarSurface 的实色实现。
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        containerColor = containerColor,
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .windowInsetsPadding(WindowInsets.statusBarsIgnoringVisibility)
                    .padding(start = topBarStartInset),
                windowInsets = WindowInsets(0, 0, 0, 0),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    scrolledContainerColor = Color.Transparent,
                ),
                title = titleContent,
                navigationIcon = {
                    if (navigationIcon != null) {
                        Box(modifier = Modifier.padding(start = 12.dp)) { navigationIcon() }
                    }
                },
                actions = {
                    Row(modifier = Modifier.padding(end = 12.dp), verticalAlignment = Alignment.CenterVertically) {
                        actions()
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
    ) { padding ->
        val topPadding = padding.calculateTopPadding()
        Box(modifier = Modifier.fillMaxSize()) {
            content(
                topPadding,
                padding.calculateBottomPadding(),
            )
            if (topScrimEnabled) {
                TopScrim(height = topPadding)
            }
        }
    }
}

@Composable
fun TopScrim(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.surfaceContainer,
    height: Dp = with(androidx.compose.ui.platform.LocalDensity.current) {
        (WindowInsets.statusBarsIgnoringVisibility.getTop(this) * 1.2f).toDp()
    },
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .background(
                Brush.verticalGradient(
                    0f to color.copy(alpha = 0.95f),
                    0.5f to color.copy(alpha = 0.7f),
                    1f to Color.Transparent,
                )
            ),
    )
}

@Composable
fun TopBarActionBox(
    @DrawableRes iconRes: Int,
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    tint: Color = MaterialTheme.colorScheme.onSurface,
    fallbackColor: Color = MaterialTheme.colorScheme.surfaceBright,
) {
    Box(
        modifier = modifier
            .size(40.dp)
            .glassTopBarSurface(CircleShape, fallbackColor)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = contentDescription,
            tint = tint,
            modifier = Modifier.size(22.dp),
        )
    }
}
