package fgsystem.franol.axumfoodreservation_sy


import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import com.google.android.material.snackbar.Snackbar
import com.rengwuxian.materialedittext.MaterialEditText
import kotlinx.android.synthetic.main.fragment_fragment___login.*
import uk.co.chrisjenx.calligraphy.CalligraphyConfig


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Login_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login_fragment, container, false)
        // Inflate the layout for this fragment






        val btnRegister = view.findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener {
            showRegisterdialog()
        }

//
//        btnSignIn.setOnClickListener { showLoginDialog() }
        CalligraphyConfig.initDefault(
            CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/fonts.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )


        return view
    }




    private fun showLoginDialog() {


        val dialog = AlertDialog.Builder(getActivity()!!.getApplicationContext())
        dialog.setTitle("SIGN IN")
        dialog.setMessage("Please use email to sign in")

        val inflater = LayoutInflater.from(getActivity()!!.getApplicationContext())
        val login_layout = inflater.inflate(R.layout.layout_login, null)
        val edtEmail = login_layout.findViewById<MaterialEditText>(R.id.edtEmail)
        val edtPassword = login_layout.findViewById<MaterialEditText>(R.id.edtPassword)

        dialog.setView(login_layout)

        //set button

        dialog.setPositiveButton("SIGN IN", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()

            //set disable button Sign In if is processing
            btnSignIn.isEnabled = false


            //check validiation
            if (TextUtils.isEmpty(edtEmail.text!!.toString())) {
                Snackbar.make(rootLayout, "Please enter email address", Snackbar.LENGTH_SHORT).show()
                return@OnClickListener
            }

            if (TextUtils.isEmpty(edtPassword.text!!.toString())) {
                Snackbar.make(rootLayout, "Please enter password address", Snackbar.LENGTH_SHORT).show()
                return@OnClickListener
            }


            if (edtPassword.text!!.toString().length < 6) {
                Snackbar.make(rootLayout, "Password too short !!!", Snackbar.LENGTH_SHORT).show()
                return@OnClickListener
            }
            //
            //                        AlertDialog watingDialog = new SpotsDialog(MainActivity.this);
            //                        watingDialog.show();
            //login

            //                        auth.signInWithEmailAndPassword(edtEmail.getText().toString(),edtPassword.getText().toString())
            //                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            //                                    @Override
            //                                    public void onSuccess(AuthResult authResult) {
            //                                        startActivity(new Intent(MainActivity.this,Welcome.class));
            //                                        finish();
            //                                    }
            //                                }).addOnFailureListener(new OnFailureListener() {
            //                            @Override
            //                            public void onFailure(@NonNull Exception e) {
            //                                Snackbar.make(rootLayout,"Failed"+e.getMessage(),Snackbar.LENGTH_SHORT)
            //                                        .show();
            //                            }
            //                        });
            btnSignIn.isEnabled = true
        })

        dialog.setNegativeButton("CANCEL") { dialog, which -> dialog.dismiss() }


        dialog.show()


    }

    private fun showRegisterdialog() {
        val dialog = AlertDialog.Builder(getActivity()!!.getApplicationContext())
        dialog.setTitle("REGISTER")
        dialog.setMessage("Please use email to register")

        val inflater = LayoutInflater.from(getActivity()!!.getApplicationContext())
        val register_layout = inflater.inflate(R.layout.layout_register, null)
        val edtEmail = register_layout.findViewById<MaterialEditText>(R.id.edtEmail)
        val edtPassword = register_layout.findViewById<MaterialEditText>(R.id.edtPassword)
        val edtName = register_layout.findViewById<MaterialEditText>(R.id.edtName)
        val edtPhone = register_layout.findViewById<MaterialEditText>(R.id.edtPhone)

        dialog.setView(register_layout)

        //set button

        dialog.setPositiveButton("REGISTER", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()

            //check validiation
            if (TextUtils.isEmpty(edtEmail.text!!.toString())) {
                Snackbar.make(rootLayout, "Please enter email address", Snackbar.LENGTH_SHORT).show()
                return@OnClickListener
            }

            if (TextUtils.isEmpty(edtPassword.text!!.toString())) {
                Snackbar.make(rootLayout, "Please enter password address", Snackbar.LENGTH_SHORT).show()
                return@OnClickListener
            }

            if (TextUtils.isEmpty(edtName.text!!.toString())) {
                Snackbar.make(rootLayout, "Please enter Name address", Snackbar.LENGTH_SHORT).show()
                return@OnClickListener
            }

            if (TextUtils.isEmpty(edtPhone.text!!.toString())) {
                Snackbar.make(rootLayout, "Please Phone email address", Snackbar.LENGTH_SHORT).show()
                return@OnClickListener
            }

            if (edtPassword.text!!.toString().length < 6) {
                Snackbar.make(rootLayout, "Password too short !!!", Snackbar.LENGTH_SHORT).show()
                return@OnClickListener
            }

        })
        dialog.setNegativeButton("CANCEL") { dialog, which -> dialog.dismiss() }


        dialog.show()
    }
}

//Register new user

//            auth!!.createUserWithEmailAndPassword(edtEmail.text!!.toString(), edtPassword.text!!.toString())
//                .addOnSuccessListener(OnSuccessListener {
//                    //save user to db
//                    val user = User()
//                    user.email = edtEmail.text!!.toString()
//                    user.name = edtName.text!!.toString()
//                    user.phone = edtPhone.text!!.toString()
//                    user.passowrd = edtPassword.text!!.toString()
//
//
//                    //use email to key
//                    users!!.child(FirebaseAuth.getInstance().currentUser!!.uid)
//                        .setValue(user)
//                        .addOnSuccessListener(OnSuccessListener {
//                            Snackbar.make(rootLayout, "Register success fully !!!", Snackbar.LENGTH_SHORT).show()
//                            return@OnSuccessListener
//                        })
//                        .addOnFailureListener(OnFailureListener { e ->
//                            Snackbar.make(rootLayout, "Failed " + e.message, Snackbar.LENGTH_SHORT).show()
//                            return@OnFailureListener
//                        })
//                })
//                .addOnFailureListener(OnFailureListener { e ->
//                    Snackbar.make(rootLayout, "Failed " + e.message, Snackbar.LENGTH_SHORT).show()
//                    return@OnFailureListener
//                })
//        }).setNegativeButton("CANCEL") { dialog, which -> dialog.dismiss() }
//

//        dialog.show()


//    }
//}




