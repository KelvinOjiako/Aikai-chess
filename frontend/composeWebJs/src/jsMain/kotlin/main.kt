
import org.jetbrains.skiko.wasm.onWasmReady

fun main(){
    onWasmReady {
        BrowserViewportWindowCanvasResize("Experiment") {
            //Text("Compose web index!!!")
            App()
        }
    }
}