package com.example.besafeapp.data

import android.content.Context
import android.util.Log
import com.example.besafeapp.data.Datasource.Companion.FILE_NAME
import com.example.besafeapp.model.SecurityTopic
import org.json.JSONObject
import java.io.*

class Datasource{
    fun loadTopics(): List<SecurityTopic> {
        return return listOf<SecurityTopic>(SecurityTopic(1, "Използване на сигурна парола", "Препоръчително е паролата ви да съдържа минимум 12 символа, които да бъдат малки и големи букви, цифри и други (специални) символи. Все пак при създаването на силна парола не е толкова важно да се използват символи от четирите изброени категории, колкото да бъде възможно по-дълга."),
            SecurityTopic(2, "Аутентикация в две или повече стъпки", "Този тип аутентикация добавя още един слой при достъп до даден акаунт, като изисква втори фактор като код пратен по имейла в допълнение на паролата."),
            SecurityTopic(3, "Редовна актуализация на софтуера", "Редовното актуализиране на различните приложения ги поддържа в крак с най-новите мерки за сигурност"),
            SecurityTopic(4, "Използване на различни пароли за различните платформи", "Използването на различни пароли означава, че при изтичането на някоя от тях, ние губим достъп до една платформа, но всички останали са сигурни."),
            SecurityTopic(5, "Не отварям съмнителни линкове и не свалям съмнителни файлове", "Възможно е линковете привидно да приличат на официалните такива. Например може да се замене една буква от линк на верига магазини с подобно изглеждаща, за да може хората да клекнат върху него."),
            SecurityTopic(6, "Използвам VPN (Виртуална Частна Мрежа)", "")
        )
    }

    companion object{
        const val FILE_NAME = "safetyCheck.txt"
    }

    fun readFile(context: Context): JSONObject {
        val file = File(context.filesDir, FILE_NAME)

        val inputStream: InputStream = context.openFileInput(FILE_NAME)
        val reader = BufferedReader(InputStreamReader(inputStream))
        val stringBuilder = StringBuilder()
        var line: String? = reader.readLine()
        while (line != null) {
            stringBuilder.append(line).append("\n")
            line = reader.readLine()
        }
        reader.close()
        return JSONObject(stringBuilder.toString())
    }

    fun writeFile(string:String, context: Context){
        Log.d("TAG", string)
        context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE).use {
            it.write(string.toByteArray())
        }
    }
}
