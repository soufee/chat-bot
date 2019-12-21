package mainpack

import java.util.*
import java.util.regex.Pattern

class SimpleBot {
    var pattern: Pattern = "".toPattern()
    val random = Random()

    val COMMON_PHRASES = listOf(
        "Нет ничего ценее слов, сказанных к месту и ко времени",
        "Порой молчание может сказать больше, нежели уйма слов",
        "Перед тем как писать/говорить, всегда лучше подумать",
        "Вежливая и грамотная речь говорит о величии души",
        "Приятно, когда текст без орфографических ошибок",
        "Многословие есть признак неупорядоченного ума",
        "Слова могут ранить, но могут и исцелить",
        "Записывая слова, мы удваиваем их силу",
        "Кто ясно мыслит, тот ясно излагает",
        "Боюсь Вы что-то недоговариваете"
    )
    val ELUSIVE_ANSWER = listOf(
        "Вопрос непростой, прошу таймаут на раздумья",
        "Не уверен, что располагаю такой информацией",
        "Может лучше поговорим о чем-то другом?",
        "Простите, но это очень личный вопрос",
        "Не уверен, что Вам понравится ответ",
        "Поверьте, я сам хотел бы это знать",
        "Вы действительно хотите это знать?",
        "Уверен, вы уже догадались сами",
        "Зачем вам такая информация?",
        "Давайте сохраним интригу"
    )

    val PATTERNS_FOR_ANALIS = mapOf(
        "хай".toPattern() to "hello",
        "привет".toPattern() to "hello",
        "здорово".toPattern() to "hello",
        "здравствуй".toPattern() to "hello",

        "кто\\s.*ты".toPattern() to "who",
        "ты\\s.*кто".toPattern() to "who",

        "как\\s.*зовут".toPattern() to "name",
        "как\\s.*имя".toPattern() to "name",
        "есть\\s.*имя".toPattern() to "name",
        "какое\\s.*имя".toPattern() to "name",

        "как\\s.*дела".toPattern() to "howareyou",
        "как\\s.*жизнь".toPattern() to "howareyou",

        "зачем\\s.*тут".toPattern() to "whatdoyoudoing",
        "зачем\\s.*здесь".toPattern() to "whatdoyoudoing",
        "что\\s.*делаешь".toPattern() to "whatdoyoudoing",
        "чем\\s.*занимаешься".toPattern() to "whatdoyoudoing",

        "что\\s.*нравится".toPattern() to "whatdoyoulike",
        "что\\s.*любишь".toPattern() to "whatdoyoulike",

        "кажется".toPattern() to "iamfeelling",
        "чувствую".toPattern() to "iamfeelling",
        "испытываю".toPattern() to "iamfeelling",

        "^да".toPattern() to "yes",
        "согласен".toPattern() to "yes",
        "который\\s.*час".toPattern() to "whattime",
        "сколько\\s.*время".toPattern() to "whattime",

        "прощай".toPattern() to "bye",
        "увидимся".toPattern() to "bye",
        "до\\s.*свидания".toPattern() to "bye"
    )

    val ANSWERS_BY_PATTERNS = mapOf(
        "hello" to "Здравствуйте, рад Вас видеть.",
        "who" to "Я обычный чат-бот.",
        "name" to "Зовите меня Чаттер :)",
        "howareyou" to "Спасибо, что интересуетесь. У меня всё хорошо.",
        "whatdoyoudoing" to "Я пробую общаться с людьми.",
        "whatdoyoulike" to "Мне нравиться думать что я не просто программа.",
        "iamfeelling" to "Как давно это началось? Расскажите чуть подробнее.",
        "yes" to "Согласие есть продукт при полном непротивлении сторон.",
        "bye" to "До свидания. Надеюсь, ещё увидимся."
    )

    fun sayInReturn(msg: String?, ai: Boolean): String {
        val say = if (msg?.trim()?.endsWith("?") == true) ELUSIVE_ANSWER[random.nextInt(ELUSIVE_ANSWER.size)]
        else COMMON_PHRASES[random.nextInt(COMMON_PHRASES.size)]
        if (ai) {
            val message = java.lang.String.join(" ", msg?.toLowerCase()?.split("[ {,|.}?]+"))
            for ((key, value) in PATTERNS_FOR_ANALIS) {
                pattern = key
                if (pattern.matcher(message).find()) {
                    if (value.equals("whattime")) return Date().toString()
                    else return ANSWERS_BY_PATTERNS.getOrDefault(value, "Не знаю что сказать")
                }
            }
        }
        return say
    }

}