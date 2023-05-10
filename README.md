# Traning-Timer

- [ ] Переделать макет окна редактирования одного элемента тренировки для конфигурации в половину экрана (в данный моменты виджеты накладываются один на другой).

- [ ] Переделать макет окна "Отчет" для конфигурации в половину экрана (в данный моменты виджеты накладываются один на другой).

- [ ] Сделать изменяемым диапазон видимости значений графика.

- [ ] Сделать индикацию попадания в углы срабатывания таймера. Возможная реализация: если в телефон в нужном диапозоне углов горизонтально, то лампочки (или линии вверху и нихзу экрана) горяг зеленым. Если телефон не в нужном диапазоне, то лампочки горят красным в зависимости о того каком диапазон вышел и появляются указывающие стрелки куда повернуть телефон. Либо сделать так: сделать линию сбоку экрана и по ней будет перекатываться шарик в зависимости от положения телефона. В положении срабатывания шарик будет на середине либо между краями. Подумать о реализации с помощью SeekBar/
 
- [ ] Сделать так чтобы во время тренировки был виден результат предыдущей тренировки. Возможный вариант реализации: отображение на самих кнопках подхода количества раз последней тренировки. Сделать опциональным.
- [ ] Сделать чтобы состояние фильтра запоминалолось. Например, выбрал определенный вид тренировки, закрыл приложение и при открытии будет отображен тот же фильтр. Сделать так чтобы это было опционально, т.е. можно было включить и выключить как настройку.
- [ ] Сделать так, чтобы в списке, в каждой тренировке количество раз было зеленым цветом если в предыдущей тренировке было меньше раз и красным если было больше. Так будет наглядко виден прогресс. Сделать чтобы это выло видно только при выборе в фильтре определенного вида тренировки.
- [ ] Подумать о том, чтобы сделать макет следующим образом: вывести в верхнуюю половину экрана график, а в нижнюю список. При выборе точки на графике выделять в списке выбранную тренировки и наоборот, при выборе строчки в списке подсвечивать точку на графике.

- [ ] Сделать автоматизацию ввода количества раз в подходе. Мы знаем, что количество раз в текущем подходе будет на 1 больше чем в предыдущем. После выполнения подхода и установки таймера отдыха можно автоматически записывать количество раз в подходе. При автоматической записи (как вариант) нужно запустить диалоговое окно, чтобы подтвердить записываемое количество раз. Диалог будет содежать две большие кнопки ДА и НЕТ. При выборе нет, будет запущена палитра с выбором количества раз (так как сделано сейчас).

- [ ] Сделать так чтобы после ввода количества раз последнего подхода автоматически добавлялась запись в базу данных и приложение выключалось. Либо как вариант сохранять и выключать приложение при срабатывании признака включения таймера при условии что количество раз в последнем подходе уже введено. Опция должна быть отключаемая из окна настроек.
- [ ] Сделать чтобы кнопка остановки таймера была неактивна если таймер не установлен.
- [ ] Сделать так чтобы при срабатывании таймера открывалось тренировочное приложение, если в данный момент находишься в другом приложении.
- [ ] Сделать экспорт и импорт данных БД.
- [ ] Сделать окно настроек.
- [ ] Сделать так чтобы при установке будильника на экране чтобо загоралось, чтобы было видно что будильник установлен. Также подумать о выводе количества секунд до срабатывания таймера на экран.

- [ ] Сделать чтобы на экране было постоянно видно время до конца таймера
- [ ] подумать об автоматизации приложения тренировок. сохранение не в заметки, а в локальную базу данных. это первое. второе. сделать фиксирование времени между подходами и время одходов. каждый раз когда я отмечаю подход, либо ставлю таймер на тренировку должно фиксироваться время. добавить фиксацию начала тренировки при определенноем условии (пока не понятно при каком, либо при старте приложения, либо при нажатии на первй подход, подумать при каком.)
- [ ] Попробовать написать класс для управления будильником
- [ ] сейчас время до окончания таймера подвязано на корутину. но т.к. у меня в сервисе есть листенер, кторый крутится постоянно, то можно сделать привязку к нему
- [ ] подумать как сделать переключалку для музыки, след. трек, пред. трек и т.п.
- [ ] сделать так чтобы при начале тренировки фиксировалось время начала тренировке и в конце время конца, далее в отчет выводилась длительность тренировки
- [ ] подумат как сделать чтобы можно было с помощью кнопки запускать два заведомо известных приложения в режиме разделенного экрана.

- [x] В окне выбора количества раз в подходе добавить возможность выбора 0 повторений.
- [x] В базе данных хранения тренировок сделать поле объекта, которой будет обозначать, что тренировка не обработана. Для чего это нужно: я потренировался, сохранил тренировку в БД, но еще не полностью проверил что все указано верно. Я погружаю БД, смотрю список не обработанных тренировок, обрабатываю, вижу что все указано верно, сохраняю и ставлю флаг что тренировка обработана. Т.е. это такое буфер между сохранненнными тренриовками и и промежуточными результаты которых я еще не обработал.
- [x] подумать над внедрением БД и сохранение результата тренировки туда. Можно будет выводить графики с результатами тренировок и тп.
- [x] В реализации закрытия стартового активити при закрытии главного активити, с главного активити всегда приходит результат "не OK". Закрытие сейчас подвязано на любой результат. Не критично, но нужно разобрать почему не работает.
- [x] сделать возможность отмены выставленного будильника.
- [x] сделать так чтобы за 10 секунд (или другой промежуток времени) до конца подавался сигнал о том что скоро подход.
- [x] Подумать о модификации приложения в следующем виде: при входе приложение предлагается выбрать тип тренировок (для сохранения типа тренировок в отчете). Далее экран управления приложение с кнопками управления и одной большой кнопкой для открытия экрана с подходами и далее экран с количетсвом повторейний.
- [x] При очистке sharedPrefernces при сбросе, очищается также время отдыха между подходами. Из-за этого при стартре приложения время между подходами выставляется в 0. Исправить.
- [x] при реализации хранении в БД дата класс сделать строковым. строка будет в след формате подход1.времяотдыха1.подход1 и т.д. при подгрузке строку можно разделить, понять сколько было подходов и время между подходами.
- [x] Приложение перестает реагировать через некоторое время после выключения экрана (не работает вибрация, не реагирует на команды). (Дело было в оптимизации расхода батареи. Его нужно выключать чтобы система не убивала твое приложение. Решено проверкой оптимизировано ли приложение при входе и запуска окна настроек для выключения оптимизации)
- [x] сделать возможность отмены выставленного будильника.
- [x] Постоянно слетает время тренировок, какие то проблемы с SharedPreferences. Разаобраться.
