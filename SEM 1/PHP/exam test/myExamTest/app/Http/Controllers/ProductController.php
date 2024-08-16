<?php

namespace App\Http\Controllers;

use App\Models\Product;
use Illuminate\Http\Request;


class ProductController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
        $data = Product::all();
        return view('index', compact('data'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
        return view('create');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        //validate
        $request->validate([
            'ProductType'         =>  'required|alpha_dash',
            'ProductCode'         =>  'required|alpha_dash',
            'ProductName'         =>  'required',
            'Quantity'            =>  'required',
        ]);

        $product = new Product();
        $product->ProductType = $request->ProductType;
        $product->ProductCode = $request->ProductCode;
        $product->ProductName = $request->ProductName;
        $product->Quantity = $request->Quantity;
        $product->Note = $request->Note;

        $product->save();

        return redirect()->route('product.index');
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Product  $product
     * @return \Illuminate\Http\Response
     */
    public function show(Product $product)
    {
        //
        return view('show', compact('product'));
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Product  $product
     * @return \Illuminate\Http\Response
     */
    public function edit(Product $product)
    {
        //
        return view('edit', compact('product'));
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Product  $product
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Product $product)
    {
        //
        $request->validate([
            'ProductType'         =>  'required|alpha_dash',
            'ProductCode'         =>  'required|alpha_dash',
            'ProductName'         =>  'required',
            'Quantity'            =>  'required',
        ]);



        $product = Product::find($request->hidden_id);

        $product->ProductType = $request->ProductType;

        $product->ProductCode = $request->ProductCode;

        $product->ProductName = $request->ProductName;

        $product->Quantity = $request->Quantity;

        $product->Note = $request->Note;

        $product->save();

        return redirect()->route('product.index')->with('success', 'Product Data has been updated successfully');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Product  $product
     * @return \Illuminate\Http\Response
     */
    public function destroy(Product $product)
    {
        //
        $product->delete();

        return redirect()->route('product.index')->with('success', 'Product Data deleted successfully');
    }
}
