package com.appdexon.noteappjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.appdexon.noteappjetpack.screen.NoteScreen
import com.appdexon.noteappjetpack.screen.NoteViewModel
import com.appdexon.noteappjetpack.ui.theme.NoteAppJetPackTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity(
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppJetPackTheme(darkTheme = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val noteViewModel = viewModel<NoteViewModel>()
//                    val noteViewModel: NoteViewModel by viewModels()// This also works
                    NotesApp(noteViewModel = noteViewModel)

                }
            }
        }
    }
}


@Composable
fun NotesApp(noteViewModel: NoteViewModel) {
    val notesList = noteViewModel.noteList.collectAsState().value

    NoteScreen(notes = notesList,
        onAddNote = { noteViewModel.addNote(it) },
        onRemoveNote = { noteViewModel.removeNote(it) })
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NoteAppJetPackTheme {
    }
}