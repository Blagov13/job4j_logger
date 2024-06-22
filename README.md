# Job4j Logger

📝 В этом репозитории содержится проект Job4j Logger, представляющий собой простую библиотеку журналирования для приложений Java.

## Функции

🚀 Вот некоторые ключевые функции Job4j Logger:
- Возможность регистрации сообщений на разных уровнях (INFO, DEBUG, ERROR)
- Настраиваемое форматирование журнала
- Запись сообщений журнала в консоль и файл

## Начало работы

🔧 Чтобы начать работу с Job4j Logger, выполните следующие шаги:
1. Клонируйте этот репозиторий на локальную машину
2. Соберите проект с помощью Maven
3. Используйте класс Logger в своем приложении Java для регистрации сообщений

## Использование

⚙️ Вот пример того, как можно использовать Job4j Logger в вашем приложении Java:

```java
import org.job4j.logger.Logger;

public class MyApp {
    private static final Logger LOGGER = new Logger();

    public static void main(String[] args) {
        LOGGER.info("This is an info message");
        LOGGER.debug("This is a debug message");
        LOGGER.error("This is an error message");
    }
}
```

## Конфигурация

⚙️ Вы можете настроить Job4j Logger, изменив файл `log.properties` в каталоге `src/main/resources`.

## Контакты

Если у вас есть вопросы или предложения, пожалуйста, свяжитесь с нами:

- Автор проекта: [Blagov13](https://github.com/Blagov13)
- Электронная почта: blagov13rus@gmail.com
