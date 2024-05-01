# CSE 143 Assignment 3
##README
Ojas Upadhye, Sriharsha Maddala, Tanay Khajanchi, Sean Fujiwara
Spring 2023

In this project, you will be implementing Text Classification and working with the Viterbi Algorithm for sequence labeling. 

The program is to be written in Python3. 

Objectives:
1. Text Classification with Neural Networks
2. Deriving the Viterbi Algorithm ( No code )
3. Implementing the Viterbi algorithm

### 1 - Text Classification with Neural Networks

Dataset:
You will build the text classifier for analyzing if text (a sentence) has a positive or negative sentiment.
The dataset used will be the IMDb reviews dataset; a standard sentiment analysis dataset based on movie reviews.

Starter code:
*Speech and Language Processing: An introduction to natural language processing, computation linguistics, and speech recognition*, Daniel Jurafsky & James H. Martin.
OR
Safari Books Online - Natural Language Processing with RNNs and Attention
Ch. 16.2.0 - Sentiment Analysis
Ch. 16.2.1 - Masking
Ch. 16.2.2 - Reusing Pretrained Embeddings
Along with the code in the above readings, the Tensorflow introduction to Keras may also be a useful resource.

#### 1.1: Text Classification with RNNs
Using Keras, build a RNN-based text classifier.
Implement a Keras model which performs the following:
1. Embed input text as a sequence of vectors
2. Transform the embedded sequence into a vector using a simple single-layer RNN
3. Apply a feed-forward layer on that vector to obtain a label

You will also still need to make decision on hyperparameters. here are some starters:
* Choice of nonlinearity = tahn
* Word embedding dimension size = 16
* Hidden dimension size = 64
* Dropout rate = 5
* Choice of optimization method = adam
* Learning rate = 10^-3
* Training batch size = 32
* Number of training epochs = 20

#### 1.2: Text Classification with LSTMs
Using the same hyperparameter for part 1.1, update and modify your model to implement LSTM units.
You may have noticed that our simple RNN model has two main problems, related to each other:
* "Vanishing Gradients" during teh learning phase for the model incur difficulties in propagating errors into the distant past, far far away.
* The **State** of the model is volatile - tends to go under many changes on each iteration; this causes the model to be more prone to errors/loss and "forgets" too much to our liking.
Compare the LSTM model's performance tot eh simple RNN model from section 1.1.


### 2 - The Viterbi Algorithm
**Theory - No Code**
When performing structured prediction in sequence labeling we want to find the sequence of tags that maximizes some global scoring function:
*yCAP = argmax_y S(x, y)*
where *S* maps a sentence *x* and a tag sequence *y* to a real number. There are *n* number of tokens in *x*, with the start and stop symbols. Same for *y*.
The process of computing the highest scoring tag sequence is called *decoding*. In your model, compute your global score as the sum of local scores:
*S(x, y) = sum(s(x, i, y_i - 1, y_i)* for *n + 1* with *i* = 1.

Resources:
*Natural Language Processing*, Jacob Eisenstein. **URL** { `https://github.com/jacobeisenstein/gt-nlp-class/raw/master/notes/eisenstein-nlp-notes.pdf` }
Ch. 7 - Phonetics


### 3 - Implementing the Viterbi algorithm
This section will take you over another sequence labeling task: *named entity recognition (NER)*
You will implement the Viterbi algorithm for a named entity recognition system. 

Dataset:
The data you will be using for this section of the assignment is from the CoNLL 2003 shared task on named entity recognition.

Starter Code - Provided Files:
* `CSE-143_A3_Code.ipynb`: contains starter code
* `new.train`: contains training data
* `ner.dev`: contains development data for early stopping
* `ner.test`: contains test data - *Do not use test data to train your models in any way*
* `model.simple`: contains a trained model to use for the Viterbi algorithm
* `evaluate.py`: contains Evaluation code - a Python reimplementation of teh CoNLL 2003 evaluation script
The starter code implements a simple NER system using a linear model with features. You are to implement the Viterbi algortihm.
The data, trained model, and code are all available in a Google drive folder.

#### 3.1 - Viterbi Algorithm    { Coding }
Implement `decode(input_length, tagset, score)` using the Viterbi algorithm from part 2.

Resources:
*Natural Language Processing*, Jacob Eisenstein. **URL** { `https://github.com/jacobeisenstein/gt-nlp-class/raw/master/notes/eisenstein-nlp-notes.pdf` }
Ch. 7, Section 7.3 - Algorithm 11


## Program Testing
The project can be developed and ran on Google Colab 
Part 1:
**URL** 
{ `colab.research.google.com` }
{ `PART_1.ipynb` }

Part 3:
At the very bottom of `CSE-143_A3_Code.ipynb` or `cse_143_a3_code.py` there are three lines:
* `test_decoder()`: Uncomment to test the decoder on a simple example
* `main_train()`: Uncomment to train a model (`sgd` function is a dependency)
* `main_predict('ner.dev', 'model.simple')`: Uncomment to predict on `dev.ner` using the model `model.simple` (`decode` function is a dependency)
Developing and running code to test is still recommended using Google Colab. 
**URL**
{ `CSE-143_A3_Code.ipynb` }
{ `cse_143_a3_code.py` }


### Deliverables
- `part_1.py`: Contains implementations of Text Classification models with RNNs and LSTMs
- `PART_1.ipynb`: Google Colab file containing above implementation of Text Classification
- `cse_143-a3_code.py`: Contains implementation of Named Entity Recognition with Viterbi Algorithm
- `CSE-143_A3_Code.ipynb`: Google Colab file containing above implementation of NER
- `ner.dev.out`: Contains output for the dev set
- `WRITEUP.pdf`: Contains model descriptions, research questions, and program report
- `README.md`: Contains instructions on how to build and run code, along with program objectives
