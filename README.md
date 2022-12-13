# Traning-Timer
- [ ] В базе данных хранения тренировок сделать поле объекта, которой будет обозначать, что тренировка не обработана. Для чего это нужно: я потренировался, сохранил тренировку в БД, но еще не полностью проверил что все указано верно. Я погружаю БД, смотрю список не обработанных тренировок, обрабатываю, вижу что все указано верно, сохраняю и ставлю флаг что тренировка обработана. Т.е. это такое буфер между сохранненнными тренриовками и и промежуточными результаты которых я еще не обработал
- [ ] подумать об автоматизации приложения тренировок. сохранение не в заметки, а в локальную базу данных. это первое. второе. сделать фиксирование времени между подходами и время одходов. каждый раз когда я отмечаю подход, либо ставлю таймер на тренировку должно фиксироваться время. добавить фиксацию начала тренировки при определенноем условии (пока не понятно при каком, либо при старте приложения, либо при нажатии на первй подход, подумать при каком.)
- [ ] Попробовать написать класс для управления будильником
- [ ] подумать над внедрением БД и сохранение результата тренировки туда. Можно будет выводить графики с результатами тренировок и тп.
- [ ] сделать возможность отмены выставленного будильника.
- [ ] сейчас время до окончания таймера подвязано на корутину. но т.к. у меня в сервисе есть листенер, кторый крутится постоянно, то можно сделать привязку к нему
- [ ] сделать так чтобы за 10 секунд (или другой промежуток времени) до конца подавался сигнал о том что скоро подход.
- [ ] подумать как сделать переключалку для музыки, след. трек, пред. трек и т.п.
- [ ] сделать так чтобы при начале тренировки фиксировалось время начала тренировке и в конце время конца, далее в отчет выводилась длительность тренировки
- [ ] подумат как сделать чтобы можно было с помощью кнопки запускать два заведомо известных приложения в режиме разделенного экрана.
