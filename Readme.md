### AsyncTask -
## Definition -
Updating UI from the separate thread is the most encountered scenario.
for such scenarios, Android has provided us API which is called as AsyncTask.



## AsyncTask Have four methods -
1. PreExecute
1. DoInBackground (must override)
1. ProgressUpdate
1. PostExecute

## Explanation -
# doInBackgrond - 
Android runs long running task in doInBackground, android runs doInBackground in Separate Thread.<br>
Android Itself creates the separate thread for doInBackground.<br>
# PreExecute - <br>
It is initialised before doInBackground<br>
Anything initialisation is to be done before performing any task in the background is to be done in PreExecute.<br>
<br>
# PostExecute<br>
it is called after DoInBackground<br>
It executes on UI Thread.<br>
after performing task in background to update result on UIThread PostExecute Method get called.<br>
<br>
# ProgressUpdate<br>
Prgressupdate is called when You want to continually update UI of UIThread from doInBackground and also wants to come back and perform task in doInBackground.<br>
to do that you have to call<br>
**publishProgress** from doInbackground<br>
