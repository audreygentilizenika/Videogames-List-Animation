package com.zenika.hdl_0707

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zenika.hdl_0707.ui.theme.HDL_0707Theme

private val games = listOf("pokemon", "zelda", "mario kart")
private val icons = listOf(Icons.Filled.Search, Icons.Filled.Build, Icons.Filled.Settings)

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun GameList() {
    LazyColumn() {
        items(games.size) { gameId ->
            var state by remember {
                mutableStateOf(false)
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = games[gameId],
                    modifier = Modifier.align(Alignment.Center)
                )
                Button(
                    onClick = { state = !state },
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(20.dp),
                    colors = ButtonDefaults.buttonColors(Color.Blue)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = stringResource(id = R.string.add)
                    )
                }
                AnimatedVisibility(
                    state,
                    enter = scaleIn(animationSpec = spring(stiffness = 3500f), initialScale = 0.5f) + fadeIn(),
                    exit = scaleOut(targetScale = 0.5f) + fadeOut()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                            .background(MaterialTheme.colorScheme.primaryContainer, shape = RoundedCornerShape(12.dp))
                            .padding(8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = icons[gameId],
                            contentDescription = stringResource(id = R.string.add),
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                        )
                        Text(
                            text = "option",
                            modifier = Modifier.align(Alignment.Center)
                        )
                        Button(
                            onClick = { state = !state },
                            modifier = Modifier
                                .align(Alignment.CenterEnd),
                            colors = ButtonDefaults.buttonColors(Color.Red)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = stringResource(id = R.string.close)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GameListPreview() {
    HDL_0707Theme {
        GameList()
    }
}
