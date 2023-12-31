# Tarakasura - консольная игра, тестовое в 'Heads and Hands'
- Реализованы все основные требования: базовые классы и их атрибуты.
- Реакция объектов на некорректные вводимые значения реализована и протестирована. Тест-классы находятся в директории /src/test/java/ru/handh/.
Для тестирования использован JUnit.
- Требуемая версия Java для корректной работы: 17 и выше.
  
## Контакты

gmail: bayzigitov.murat@gmail.com
<br>
tg: @yourpaink1ller

# Предупреждение
В игре боссы представлены с помощь ASCII-изображений. Для корректного отображения в консоли должен быть использован шрифт фиксированной ширины.
Таким образом, символы не будут смещены, и будет видна задуманная картинка. Например, вот так выглядит в идеале один из монстров.
<p align="center"><img src="https://github.com/mBayzigitov/handh-testcase-tarakasura-game/assets/91501162/7624ff4f-3a54-4e0b-9288-6eec11d4ad7e" width="550"></p>


# Для локального запуска:

1. Скачать файл .jar по <a href="https://drive.google.com/drive/folders/10AVYdN9_0GqBa9T1x8uhs0Le3_ibCoyf?usp=sharing">ссылке</a>
2. Запустить приложение командой
```java -jar tarakasura-game-1.0-SNAPSHOT.jar```

# Правила игры

- Вы играете за война, что ищет мщения. Чтобы победить Таракасуру, вы должны одолеть его приспешников.
- При встрече с монстром вы будете атаковать друг друга. Механика атаки работает с помощью бросков кубика.
Каждый из участников выполняет N бросков кубика, где N = (атака атакующего) - (защита цели атаки) + 1. Выполняется минимум 1 бросок.
- Атака считается успешной и наносит урон, если хотя бы на одном из кубиков выпало значение 5 или 6.
- В момент боя после атаки врага вы сможете воспользоваться зельем лечения. Оно излечит вам 30% от максимального здоровья.
Всего у вас имеется 4 зелья.
- После победы над монстром вам будет предложено выбрать один из нескольких предметов, что даст вам усиление в дальнейшем.
